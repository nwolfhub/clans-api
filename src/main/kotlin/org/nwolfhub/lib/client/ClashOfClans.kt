package org.nwolfhub.lib.client

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jsonMapper
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.nwolfhub.lib.response.ClashApiException
import org.nwolfhub.lib.response.ClashResponse
import org.nwolfhub.lib.response.ClientError
import org.nwolfhub.lib.response.PagedResponse

class ClashOfClans(
    private val token: String,
) {
    var baseUrl: String = "https://api.clashofclans.com/v1"

    internal var client: OkHttpClient = OkHttpClient()

    internal var json: ObjectMapper = JsonMapper.Builder(jsonMapper())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .build() //todo: migrate to jackson 3. I thought I hated the spring migration enough

    fun <T : ClashResponse> execute(
        method: String,
        path: String,
        queryParams: Map<String, String> = emptyMap(),
        body: RequestBody? = null,
        clazz: Class<T>,
    ): T {
        val (code, raw) = perform(method, path, queryParams, body)

        val parsed: T = json.readValue(raw, clazz)
        parsed.code = code
        parsed.rawResponse = raw
        return parsed
    }

    fun <T : ClashResponse> executeList(
        method: String,
        path: String,
        queryParams: Map<String, String> = emptyMap(),
        body: RequestBody? = null,
        elementClass: Class<T>,
    ): List<T> {
        val (_, raw) = perform(method, path, queryParams, body)

        val pageType = json.typeFactory.constructParametricType(PagedResponse::class.java, elementClass)
        val paged: PagedResponse<T> = json.readValue(raw, pageType)
        return paged.items
    }

    internal fun jsonBody(value: Any): RequestBody =
        json.writeValueAsString(value).toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

    private fun perform(method: String, path: String, queryParams: Map<String, String>, body: RequestBody?): Pair<Int, String?> {
        val response = client.newCall(buildRequest(method, path, queryParams, body)).execute()
        val raw = readBodyAndClose(response)
        val code = response.code

        if (code !in 200..299) {
            val error = raw.let { runCatching { json.readValue(it, ClientError::class.java) }.getOrNull() }
            throw ClashApiException(code, error, raw)
        }
        return code to raw
    }

    private fun buildRequest(
        method: String,
        path: String,
        queryParams: Map<String, String>,
        body: RequestBody?,
    ): Request {
        val urlBuilder = baseUrl.toHttpUrlOrNull()!!.newBuilder()
        path.removePrefix("/").split("/").forEach { segment ->
            if (segment.isNotEmpty()) urlBuilder.addPathSegment(segment)
        }
        for ((key, value) in queryParams) {
            urlBuilder.addQueryParameter(key, value)
        }

        return Request.Builder()
            .url(urlBuilder.build())
            .method(method, body)
            .authorize(token)
            .build()
    }

    private fun readBodyAndClose(response: okhttp3.Response): String {
        val body = response.body
        val raw = body.string()
        body.close()
        return raw
    }
}

fun Request.Builder.authorize(token: String): Request.Builder =
    addHeader("Authorization", "Bearer $token")

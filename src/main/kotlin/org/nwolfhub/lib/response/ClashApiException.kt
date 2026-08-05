package org.nwolfhub.lib.response

class ClashApiException(
    val code: Int,
    val error: ClientError?,
    rawResponse: String?,
) : RuntimeException("Clash API error $code: ${error?.reason ?: rawResponse ?: "unknown"}")

package org.nwolfhub.lib.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

open class ClashResponse {
    @JsonIgnore
    var code: Int? = null

    @JsonIgnore
    var rawResponse: String? = null
}

data class PagedResponse<T>(
    @JsonProperty("items") val items: List<T> = emptyList(),
)

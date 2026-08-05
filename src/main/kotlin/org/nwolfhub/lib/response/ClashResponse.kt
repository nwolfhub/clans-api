package org.nwolfhub.lib.response

import com.fasterxml.jackson.annotation.JsonIgnore

open class ClashResponse {
    @JsonIgnore
    var code: Int? = null

    @JsonIgnore
    var rawResponse: String? = null
}

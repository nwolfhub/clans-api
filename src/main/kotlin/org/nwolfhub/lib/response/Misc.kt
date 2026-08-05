package org.nwolfhub.lib.response

data class ClientError(
    val reason: String? = null,
    val message: String? = null,
    val type: String? = null,
    val detail: Any? = null,
) : ClashResponse()

data class GoldPassSeason(
    val startTime: String? = null,
    val endTime: String? = null,
) : ClashResponse()

data class DeepLinkCreationRequest(
    val playerTags: List<String>? = null,
    val clanTag: String? = null,
    val opponentClanTag: String? = null,
) : ClashResponse()

data class DeepLinkCreationResponse(
    val link: String? = null,
) : ClashResponse()

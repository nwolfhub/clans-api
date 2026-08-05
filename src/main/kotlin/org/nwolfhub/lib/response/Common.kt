package org.nwolfhub.lib.response

data class JsonLocalizedName(
    val name: String? = null,
) : ClashResponse()

data class JsonNode(
    val value: Any? = null,
) : ClashResponse()

data class ServiceVersion(
    val major: Int? = null,
    val minor: Int? = null,
    val content: Int? = null,
) : ClashResponse()

data class PlayerHouse(
    val elements: List<PlayerHouseElement>? = null,
) : ClashResponse()

data class PlayerHouseElement(
    val id: Int? = null,
    val type: PlayerHouseElementType? = null,
) : ClashResponse()

data class BuilderBaseLeague(
    val name: JsonLocalizedName? = null,
    val id: Int? = null,
) : ClashResponse()

data class LeagueTier(
    val name: JsonLocalizedName? = null,
    val id: Int? = null,
    val iconUrls: Map<String, String>? = null,
) : ClashResponse()

data class League(
    val name: JsonLocalizedName? = null,
    val id: Int? = null,
    val iconUrls: Map<String, String>? = null,
) : ClashResponse()

data class CapitalLeague(
    val name: String? = null,
    val id: Int? = null,
) : ClashResponse()

data class WarLeague(
    val name: String? = null,
    val id: Int? = null,
) : ClashResponse()

data class Language(
    val name: String? = null,
    val id: Int? = null,
    val languageCode: String? = null,
) : ClashResponse()

data class Label(
    val name: JsonLocalizedName? = null,
    val id: Int? = null,
    val iconUrls: Map<String, String>? = null,
) : ClashResponse()

data class Location(
    val localizedName: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val isCountry: Boolean? = null,
    val countryCode: String? = null,
) : ClashResponse()

data class Replay(
    val replayData: JsonNode? = null,
    val replayTag: String? = null,
) : ClashResponse()

data class Resource(
    val name: String? = null,
    val amount: Long? = null,
) : ClashResponse()

data class VerifyTokenRequest(
    val token: String? = null,
) : ClashResponse()

data class VerifyTokenResponse(
    val tag: String? = null,
    val token: String? = null,
    val status: String? = null,
) : ClashResponse()

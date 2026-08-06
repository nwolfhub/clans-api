package org.nwolfhub.lib.response

import com.fasterxml.jackson.annotation.JsonProperty

data class Clan(
    @JsonProperty("memberList") val memberList: List<ClanMember>? = null,
    @JsonProperty("warLeague") val warLeague: WarLeague? = null,
    @JsonProperty("capitalLeague") val capitalLeague: CapitalLeague? = null,
    @JsonProperty("tag") val tag: String? = null,
    @JsonProperty("isFamilyFriendly") val isFamilyFriendly: Boolean? = null,
    @JsonProperty("requiredLeagueTier") val requiredLeagueTier: LeagueTier? = null,
    @JsonProperty("requiredBuilderBaseTrophies") val requiredBuilderBaseTrophies: Int? = null,
    @JsonProperty("requiredTownhallLevel") val requiredTownhallLevel: Int? = null,
    @JsonProperty("warFrequency") val warFrequency: WarFrequency? = null,
    @JsonProperty("clanLevel") val clanLevel: Int? = null,
    @JsonProperty("warWinStreak") val warWinStreak: Int? = null,
    @JsonProperty("warWins") val warWins: Int? = null,
    @JsonProperty("warTies") val warTies: Int? = null,
    @JsonProperty("warLosses") val warLosses: Int? = null,
    @JsonProperty("clanPoints") val clanPoints: Int? = null,
    @JsonProperty("chatLanguage") val chatLanguage: Language? = null,
    @JsonProperty("isWarLogPublic") val isWarLogPublic: Boolean? = null,
    @JsonProperty("clanBuilderBasePoints") val clanBuilderBasePoints: Int? = null,
    @JsonProperty("clanCapitalPoints") val clanCapitalPoints: Int? = null,
    @JsonProperty("requiredTrophies") val requiredTrophies: Int? = null,
    @JsonProperty("labels") val labels: List<Label>? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("location") val location: Location? = null,
    @JsonProperty("type") val type: ClanType? = null,
    @JsonProperty("members") val members: Int? = null,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("clanCapital") val clanCapital: ClanCapital? = null,
    @JsonProperty("badgeUrls") val badgeUrls: Map<String, String>? = null,
) : ClashResponse()

data class ClanMember(
    val league: League? = null,
    val leagueTier: LeagueTier? = null,
    val builderBaseLeague: BuilderBaseLeague? = null,
    val tag: String? = null,
    val name: String? = null,
    val role: PlayerRole? = null,
    val townHallLevel: Int? = null,
    val expLevel: Int? = null,
    val clanRank: Int? = null,
    val previousClanRank: Int? = null,
    val donations: Int? = null,
    val donationsReceived: Int? = null,
    val trophies: Int? = null,
    val builderBaseTrophies: Int? = null,
    val playerHouse: PlayerHouse? = null,
) : ClashResponse()

data class ClanCapital(
    val capitalHallLevel: Int? = null,
    val districts: List<ClanDistrictData>? = null,
) : ClashResponse()

data class ClanDistrictData(
    val name: JsonLocalizedName? = null,
    val id: Int? = null,
    val districtHallLevel: Int? = null,
) : ClashResponse()

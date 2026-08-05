package org.nwolfhub.lib.response

data class Clan(
    val memberList: List<ClanMember>? = null,
    val warLeague: WarLeague? = null,
    val capitalLeague: CapitalLeague? = null,
    val tag: String? = null,
    val isFamilyFriendly: Boolean? = null,
    val requiredLeagueTier: LeagueTier? = null,
    val requiredBuilderBaseTrophies: Int? = null,
    val requiredTownhallLevel: Int? = null,
    val warFrequency: WarFrequency? = null,
    val clanLevel: Int? = null,
    val warWinStreak: Int? = null,
    val warWins: Int? = null,
    val warTies: Int? = null,
    val warLosses: Int? = null,
    val clanPoints: Int? = null,
    val chatLanguage: Language? = null,
    val isWarLogPublic: Boolean? = null,
    val clanBuilderBasePoints: Int? = null,
    val clanCapitalPoints: Int? = null,
    val requiredTrophies: Int? = null,
    val labels: List<Label>? = null,
    val name: String? = null,
    val location: Location? = null,
    val type: ClanType? = null,
    val members: Int? = null,
    val description: String? = null,
    val clanCapital: ClanCapital? = null,
    val badgeUrls: Map<String, String>? = null,
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

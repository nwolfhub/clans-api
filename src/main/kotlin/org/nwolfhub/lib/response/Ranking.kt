package org.nwolfhub.lib.response

data class PlayerRanking(
    val clan: PlayerRankingClan? = null,
    val league: League? = null,
    val leagueTier: LeagueTier? = null,
    val attackWins: Int? = null,
    val defenseWins: Int? = null,
    val tag: String? = null,
    val name: String? = null,
    val expLevel: Int? = null,
    val rank: Int? = null,
    val previousRank: Int? = null,
    val trophies: Int? = null,
) : ClashResponse()

data class PlayerRankingClan(
    val tag: String? = null,
    val name: String? = null,
    val badgeUrls: Map<String, String>? = null,
) : ClashResponse()

data class ClanRanking(
    val clanLevel: Int? = null,
    val clanPoints: Int? = null,
    val location: Location? = null,
    val members: Int? = null,
    val tag: String? = null,
    val name: String? = null,
    val rank: Int? = null,
    val previousRank: Int? = null,
    val badgeUrls: Map<String, String>? = null,
) : ClashResponse()

data class PlayerBuilderBaseRanking(
    val clan: PlayerRankingClan? = null,
    val builderBaseLeague: BuilderBaseLeague? = null,
    val tag: String? = null,
    val name: String? = null,
    val expLevel: Int? = null,
    val rank: Int? = null,
    val previousRank: Int? = null,
    val builderBaseTrophies: Int? = null,
) : ClashResponse()

data class ClanBuilderBaseRanking(
    val clanPoints: Int? = null,
    val clanBuilderBasePoints: Int? = null,
) : ClashResponse()

data class ClanCapitalRanking(
    val clanPoints: Int? = null,
    val clanCapitalPoints: Int? = null,
) : ClashResponse()

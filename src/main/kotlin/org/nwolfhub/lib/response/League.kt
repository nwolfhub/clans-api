package org.nwolfhub.lib.response

data class LeagueGroup(
    val members: List<LeagueGroupMember>? = null,
    val parameters: LeagueGroupParameters? = null,
    val attackLogs: List<LeagueBattleLogEntry>? = null,
    val defenseLogs: List<LeagueBattleLogEntry>? = null,
) : ClashResponse()

data class LeagueGroupMember(
    val playerTag: String? = null,
    val playerName: String? = null,
    val clanTag: String? = null,
    val clanName: String? = null,
    val leagueTrophies: Int? = null,
    val attackWinCount: Int? = null,
    val attackLoseCount: Int? = null,
    val defenseWinCount: Int? = null,
    val defenseLoseCount: Int? = null,
) : ClashResponse()

data class LeagueGroupParameters(
    val leagueId: Int? = null,
    val maxBattles: Int? = null,
    val activeModifier: BattleModifier? = null,
    val promoteCount: Int? = null,
    val demoteCount: Int? = null,
    val seasonId: Long? = null,
) : ClashResponse()

data class LeagueBattleLogEntry(
    val opponentPlayerTag: String? = null,
    val opponentName: String? = null,
    val stars: Int? = null,
    val destructionPercentage: Int? = null,
    val trophies: Int? = null,
    val creationTime: String? = null,
) : ClashResponse()

data class LeagueSeason(
    val id: String? = null,
) : ClashResponse()

data class LeagueSeasonResult(
    val leagueSeasonId: Long? = null,
    val leagueTrophies: Int? = null,
    val leagueTierId: Int? = null,
    val placement: Int? = null,
    val attackWins: Int? = null,
    val attackLosses: Int? = null,
    val attackStars: Int? = null,
    val defenseWins: Int? = null,
    val defenseLosses: Int? = null,
    val defenseStars: Int? = null,
    val maxBattles: Int? = null,
) : ClashResponse()

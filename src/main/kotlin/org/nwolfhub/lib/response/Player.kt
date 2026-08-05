package org.nwolfhub.lib.response

data class Player(
    val clan: PlayerClan? = null,
    val league: League? = null,
    val leagueTier: LeagueTier? = null,
    val builderBaseLeague: BuilderBaseLeague? = null,
    val role: PlayerRole? = null,
    val warPreference: WarPreference? = null,
    val attackWins: Int? = null,
    val defenseWins: Int? = null,
    val townHallLevel: Int? = null,
    val townHallWeaponLevel: Int? = null,
    val legendStatistics: PlayerLegendStatistics? = null,
    val troops: List<PlayerItemLevel>? = null,
    val heroes: List<PlayerItemLevel>? = null,
    val heroEquipment: List<PlayerItemLevel>? = null,
    val spells: List<PlayerItemLevel>? = null,
    val labels: List<Label>? = null,
    val tag: String? = null,
    val name: String? = null,
    val expLevel: Int? = null,
    val trophies: Int? = null,
    val bestTrophies: Int? = null,
    val donations: Int? = null,
    val donationsReceived: Int? = null,
    val builderHallLevel: Int? = null,
    val builderBaseTrophies: Int? = null,
    val bestBuilderBaseTrophies: Int? = null,
    val warStars: Int? = null,
    val achievements: List<PlayerAchievementProgress>? = null,
    val clanCapitalContributions: Int? = null,
    val playerHouse: PlayerHouse? = null,
    val currentLeagueGroupTag: String? = null,
    val currentLeagueSeasonId: Long? = null,
    val previousLeagueGroupTag: String? = null,
    val previousLeagueSeasonId: Long? = null,
) : ClashResponse()

data class PlayerClan(
    val tag: String? = null,
    val clanLevel: Int? = null,
    val name: String? = null,
    val badgeUrls: Map<String, String>? = null,
) : ClashResponse()

data class PlayerLegendStatistics(
    val previousSeason: LegendLeagueTournamentSeasonResult? = null,
    val previousBuilderBaseSeason: LegendLeagueTournamentSeasonResult? = null,
    val bestBuilderBaseSeason: LegendLeagueTournamentSeasonResult? = null,
    val bestSeason: LegendLeagueTournamentSeasonResult? = null,
    val currentSeason: LegendLeagueTournamentSeasonResult? = null,
    val legendTrophies: Int? = null,
) : ClashResponse()

data class LegendLeagueTournamentSeasonResult(
    val trophies: Int? = null,
    val id: String? = null,
    val rank: Int? = null,
) : ClashResponse()

data class PlayerAchievementProgress(
    val stars: Int? = null,
    val value: Int? = null,
    val name: JsonLocalizedName? = null,
    val target: Int? = null,
    val info: JsonLocalizedName? = null,
    val completionInfo: JsonLocalizedName? = null,
    val village: Village? = null,
) : ClashResponse()

data class PlayerItemLevel(
    val level: Int? = null,
    val name: JsonLocalizedName? = null,
    val maxLevel: Int? = null,
    val village: Village? = null,
    val superTroopIsActive: Boolean? = null,
    val equipment: List<PlayerItemLevel>? = null,
) : ClashResponse()

data class PlayerVillage(
    val tag: String? = null,
    val village: JsonNode? = null,
) : ClashResponse()

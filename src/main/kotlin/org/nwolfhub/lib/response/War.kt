package org.nwolfhub.lib.response

data class ClanWar(
    val clan: WarClan? = null,
    val attacksPerMember: Int? = null,
    val teamSize: Int? = null,
    val opponent: WarClan? = null,
    val battleModifier: BattleModifier? = null,
    val startTime: String? = null,
    val state: WarState? = null,
    val endTime: String? = null,
    val preparationStartTime: String? = null,
) : ClashResponse()

data class WarClan(
    val destructionPercentage: Double? = null,
    val tag: String? = null,
    val name: String? = null,
    val badgeUrls: Map<String, String>? = null,
    val clanLevel: Int? = null,
    val attacks: Int? = null,
    val stars: Int? = null,
    val expEarned: Int? = null,
    val members: List<ClanWarMember>? = null,
) : ClashResponse()

data class ClanWarMember(
    val tag: String? = null,
    val name: String? = null,
    val mapPosition: Int? = null,
    val townhallLevel: Int? = null,
    val opponentAttacks: Int? = null,
    val bestOpponentAttack: ClanWarAttack? = null,
    val attacks: List<ClanWarAttack>? = null,
) : ClashResponse()

data class ClanWarAttack(
    val order: Int? = null,
    val attackerTag: String? = null,
    val defenderTag: String? = null,
    val stars: Int? = null,
    val destructionPercentage: Int? = null,
    val duration: Int? = null,
) : ClashResponse()

data class ClanWarLogEntry(
    val clan: WarClan? = null,
    val attacksPerMember: Int? = null,
    val teamSize: Int? = null,
    val opponent: WarClan? = null,
    val battleModifier: BattleModifier? = null,
    val endTime: String? = null,
    val result: ClanWarResult? = null,
) : ClashResponse()

data class BattleLogEntry(
    val battleType: BattleType? = null,
    val attack: Boolean? = null,
    val armyShareCode: String? = null,
    val opponentPlayerTag: String? = null,
    val opponentName: String? = null,
    val opponentTownHallLevel: Int? = null,
    val stars: Int? = null,
    val destructionPercentage: Int? = null,
    val lootedResources: List<Resource>? = null,
    val extraLootedResources: List<Resource>? = null,
    val availableLoot: List<Resource>? = null,
    val battleTime: Int? = null,
    val battleTimestamp: String? = null,
) : ClashResponse()

data class WarStatus(
    val enemyClanTag: String? = null,
    val warState: WarState? = null,
    val statusCode: Int? = null,
    val clanTag: String? = null,
    val timestamp: String? = null,
) : ClashResponse()

data class ClanWarLeagueGroup(
    val tag: String? = null,
    val state: ClanWarLeagueGroupState? = null,
    val season: String? = null,
    val clans: List<ClanWarLeagueClan>? = null,
    val rounds: List<ClanWarLeagueRound>? = null,
) : ClashResponse()

data class ClanWarLeagueRound(
    val warTags: List<String>? = null,
) : ClashResponse()

data class ClanWarLeagueClan(
    val tag: String? = null,
    val clanLevel: Int? = null,
    val name: String? = null,
    val members: List<ClanWarLeagueClanMember>? = null,
    val badgeUrls: Map<String, String>? = null,
) : ClashResponse()

data class ClanWarLeagueClanMember(
    val tag: String? = null,
    val townHallLevel: Int? = null,
    val name: String? = null,
) : ClashResponse()

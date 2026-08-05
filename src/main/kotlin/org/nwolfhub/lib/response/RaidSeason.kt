package org.nwolfhub.lib.response

data class ClanCapitalRaidSeason(
    val attackLog: List<ClanCapitalRaidSeasonAttackLogEntry>? = null,
    val defenseLog: List<ClanCapitalRaidSeasonDefenseLogEntry>? = null,
    val state: String? = null,
    val startTime: String? = null,
    val endTime: String? = null,
    val capitalTotalLoot: Int? = null,
    val raidsCompleted: Int? = null,
    val totalAttacks: Int? = null,
    val enemyDistrictsDestroyed: Int? = null,
    val offensiveReward: Int? = null,
    val defensiveReward: Int? = null,
    val members: List<ClanCapitalRaidSeasonMember>? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonMember(
    val tag: String? = null,
    val name: String? = null,
    val attacks: Int? = null,
    val attackLimit: Int? = null,
    val bonusAttackLimit: Int? = null,
    val capitalResourcesLooted: Int? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonAttackLogEntry(
    val defender: ClanCapitalRaidSeasonClanInfo? = null,
    val attackCount: Int? = null,
    val districtCount: Int? = null,
    val districtsDestroyed: Int? = null,
    val districts: List<ClanCapitalRaidSeasonDistrict>? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonDefenseLogEntry(
    val attacker: ClanCapitalRaidSeasonClanInfo? = null,
    val attackCount: Int? = null,
    val districtCount: Int? = null,
    val districtsDestroyed: Int? = null,
    val districts: List<ClanCapitalRaidSeasonDistrict>? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonClanInfo(
    val tag: String? = null,
    val name: String? = null,
    val level: Int? = null,
    val badgeUrls: Map<String, String>? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonDistrict(
    val stars: Int? = null,
    val name: JsonLocalizedName? = null,
    val id: Int? = null,
    val destructionPercent: Int? = null,
    val attackCount: Int? = null,
    val totalLooted: Int? = null,
    val attacks: List<ClanCapitalRaidSeasonAttack>? = null,
    val districtHallLevel: Int? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonAttack(
    val attacker: ClanCapitalRaidSeasonAttacker? = null,
    val destructionPercent: Int? = null,
    val stars: Int? = null,
) : ClashResponse()

data class ClanCapitalRaidSeasonAttacker(
    val tag: String? = null,
    val name: String? = null,
) : ClashResponse()

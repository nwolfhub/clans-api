package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.Clan
import org.nwolfhub.lib.response.ClanCapitalRaidSeason
import org.nwolfhub.lib.response.ClanMember
import org.nwolfhub.lib.response.ClanWar
import org.nwolfhub.lib.response.ClanWarLeagueGroup
import org.nwolfhub.lib.response.ClanWarLogEntry

class ClanRequest(
    val clanTag: String,
)

class ClanMembersRequest(
    val clanTag: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class CurrentWarRequest(
    val clanTag: String,
)

class ClanWarLogRequest(
    val clanTag: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class ClanWarLeagueGroupRequest(
    val clanTag: String,
)

class ClanWarLeagueWarRequest(
    val warTag: String,
)

class CapitalRaidSeasonsRequest(
    val clanTag: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class SearchClansRequest(
    val name: String? = null,
    val warFrequency: String? = null,
    val locationId: Int? = null,
    val minMembers: Int? = null,
    val maxMembers: Int? = null,
    val minClanPoints: Int? = null,
    val minClanLevel: Int? = null,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
    val labelIds: String? = null,
)

fun ClashOfClans.clan(request: ClanRequest): Clan =
    execute("GET", "/clans/${request.clanTag}", clazz = Clan::class.java)

fun ClashOfClans.clanMembers(request: ClanMembersRequest): List<ClanMember> =
    executeList(
        "GET",
        "/clans/${request.clanTag}/members",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = ClanMember::class.java,
    )

fun ClashOfClans.currentWar(request: CurrentWarRequest): ClanWar =
    execute("GET", "/clans/${request.clanTag}/currentwar", clazz = ClanWar::class.java)

fun ClashOfClans.clanWarLog(request: ClanWarLogRequest): List<ClanWarLogEntry> =
    executeList(
        "GET",
        "/clans/${request.clanTag}/warlog",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = ClanWarLogEntry::class.java,
    )

fun ClashOfClans.clanWarLeagueGroup(request: ClanWarLeagueGroupRequest): ClanWarLeagueGroup =
    execute(
        "GET",
        "/clans/${request.clanTag}/currentwar/leaguegroup",
        clazz = ClanWarLeagueGroup::class.java,
    )

fun ClashOfClans.clanWarLeagueWar(request: ClanWarLeagueWarRequest): ClanWarLeagueGroup =
    execute(
        "GET",
        "/clanwarleagues/wars/${request.warTag}",
        clazz = ClanWarLeagueGroup::class.java,
    )

fun ClashOfClans.capitalRaidSeasons(request: CapitalRaidSeasonsRequest): List<ClanCapitalRaidSeason> =
    executeList(
        "GET",
        "/clans/${request.clanTag}/capitalraidseasons",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = ClanCapitalRaidSeason::class.java,
    )

fun ClashOfClans.searchClans(request: SearchClansRequest): List<Clan> =
    executeList(
        "GET",
        "/clans",
        queryParams(
            listOfNotNull(
                request.name?.let { "name" to it },
                request.warFrequency?.let { "warFrequency" to it },
                request.locationId?.let { "locationId" to it.toString() },
                request.minMembers?.let { "minMembers" to it.toString() },
                request.maxMembers?.let { "maxMembers" to it.toString() },
                request.minClanPoints?.let { "minClanPoints" to it.toString() },
                request.minClanLevel?.let { "minClanLevel" to it.toString() },
                request.labelIds?.let { "labelIds" to it },
            ).toMap(),
            page(request.limit, request.after, request.before),
        ),
        elementClass = Clan::class.java,
    )

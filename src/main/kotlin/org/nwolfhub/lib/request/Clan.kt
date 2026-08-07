package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.tag
import org.nwolfhub.lib.response.Clan
import org.nwolfhub.lib.response.ClanCapitalRaidSeason
import org.nwolfhub.lib.response.ClanMember
import org.nwolfhub.lib.response.ClanWar
import org.nwolfhub.lib.response.ClanWarLeagueGroup
import org.nwolfhub.lib.response.ClanWarLogEntry

fun ClashOfClans.clan(clanTag: String): Clan =
    execute("GET", "/clans/${clanTag.tag()}", clazz = Clan::class.java)

fun ClashOfClans.clanMembers(
    clanTag: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<ClanMember> =
    executeList(
        "GET",
        "/clans/${clanTag.tag()}/members",
        queryParams(page(limit, after, before)),
        elementClass = ClanMember::class.java,
    )

fun ClashOfClans.currentWar(clanTag: String): ClanWar =
    execute("GET", "/clans/${clanTag.tag()}/currentwar", clazz = ClanWar::class.java)

fun ClashOfClans.clanWarLog(
    clanTag: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<ClanWarLogEntry> =
    executeList(
        "GET",
        "/clans/${clanTag.tag()}/warlog",
        queryParams(page(limit, after, before)),
        elementClass = ClanWarLogEntry::class.java,
    )

fun ClashOfClans.clanWarLeagueGroup(clanTag: String): ClanWarLeagueGroup =
    execute(
        "GET",
        "/clans/${clanTag.tag()}/currentwar/leaguegroup",
        clazz = ClanWarLeagueGroup::class.java,
    )

fun ClashOfClans.clanWarLeagueWar(warTag: String): ClanWar =
    execute(
        "GET",
        "/clanwarleagues/wars/${warTag.tag()}",
        clazz = ClanWar::class.java,
    )

fun ClashOfClans.capitalRaidSeasons(
    clanTag: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<ClanCapitalRaidSeason> =
    executeList(
        "GET",
        "/clans/${clanTag.tag()}/capitalraidseasons",
        queryParams(page(limit, after, before)),
        elementClass = ClanCapitalRaidSeason::class.java,
    )

fun ClashOfClans.searchClans(
    name: String? = null,
    warFrequency: String? = null,
    locationId: Int? = null,
    minMembers: Int? = null,
    maxMembers: Int? = null,
    minClanPoints: Int? = null,
    minClanLevel: Int? = null,
    labelIds: String? = null,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<Clan> =
    executeList(
        "GET",
        "/clans",
        queryParams(
            listOfNotNull(
                name?.let { "name" to it },
                warFrequency?.let { "warFrequency" to it },
                locationId?.let { "locationId" to it.toString() },
                minMembers?.let { "minMembers" to it.toString() },
                maxMembers?.let { "maxMembers" to it.toString() },
                minClanPoints?.let { "minClanPoints" to it.toString() },
                minClanLevel?.let { "minClanLevel" to it.toString() },
                labelIds?.let { "labelIds" to it },
            ).toMap(),
            page(limit, after, before),
        ),
        elementClass = Clan::class.java,
    )

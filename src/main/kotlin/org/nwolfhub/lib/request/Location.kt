package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.ClanBuilderBaseRanking
import org.nwolfhub.lib.response.ClanCapitalRanking
import org.nwolfhub.lib.response.ClanRanking
import org.nwolfhub.lib.response.Location
import org.nwolfhub.lib.response.PlayerBuilderBaseRanking
import org.nwolfhub.lib.response.PlayerRanking

fun ClashOfClans.location(locationId: String): Location =
    execute("GET", "/locations/$locationId", clazz = Location::class.java)

fun ClashOfClans.locations(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<Location> =
    executeList("GET", "/locations", queryParams(page(limit, after, before)), elementClass = Location::class.java)

fun ClashOfClans.clanRanking(
    locationId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<ClanRanking> =
    executeList(
        "GET",
        "/locations/$locationId/rankings/clans",
        queryParams(page(limit, after, before)),
        elementClass = ClanRanking::class.java,
    )

fun ClashOfClans.playerRanking(
    locationId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<PlayerRanking> =
    executeList(
        "GET",
        "/locations/$locationId/rankings/players",
        queryParams(page(limit, after, before)),
        elementClass = PlayerRanking::class.java,
    )

fun ClashOfClans.playerBuilderBaseRanking(
    locationId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<PlayerBuilderBaseRanking> =
    executeList(
        "GET",
        "/locations/$locationId/rankings/players-builder-base",
        queryParams(page(limit, after, before)),
        elementClass = PlayerBuilderBaseRanking::class.java,
    )

fun ClashOfClans.clanBuilderBaseRanking(
    locationId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<ClanBuilderBaseRanking> =
    executeList(
        "GET",
        "/locations/$locationId/rankings/clans-builder-base",
        queryParams(page(limit, after, before)),
        elementClass = ClanBuilderBaseRanking::class.java,
    )

fun ClashOfClans.clanCapitalRanking(
    locationId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<ClanCapitalRanking> =
    executeList(
        "GET",
        "/locations/$locationId/rankings/capitals",
        queryParams(page(limit, after, before)),
        elementClass = ClanCapitalRanking::class.java,
    )

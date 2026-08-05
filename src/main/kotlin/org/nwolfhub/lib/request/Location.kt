package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.ClanBuilderBaseRanking
import org.nwolfhub.lib.response.ClanCapitalRanking
import org.nwolfhub.lib.response.ClanRanking
import org.nwolfhub.lib.response.Location
import org.nwolfhub.lib.response.PlayerBuilderBaseRanking
import org.nwolfhub.lib.response.PlayerRanking

class LocationRequest(
    val locationId: String,
)

class LocationsRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class ClanRankingRequest(
    val locationId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class PlayerRankingRequest(
    val locationId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class PlayerBuilderBaseRankingRequest(
    val locationId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class ClanBuilderBaseRankingRequest(
    val locationId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class ClanCapitalRankingRequest(
    val locationId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

fun ClashOfClans.location(request: LocationRequest): Location =
    execute("GET", "/locations/${request.locationId}", clazz = Location::class.java)

fun ClashOfClans.locations(request: LocationsRequest): List<Location> =
    executeList("GET", "/locations", queryParams(page(request.limit, request.after, request.before)), elementClass = Location::class.java)

fun ClashOfClans.clanRanking(request: ClanRankingRequest): List<ClanRanking> =
    executeList(
        "GET",
        "/locations/${request.locationId}/rankings/clans",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = ClanRanking::class.java,
    )

fun ClashOfClans.playerRanking(request: PlayerRankingRequest): List<PlayerRanking> =
    executeList(
        "GET",
        "/locations/${request.locationId}/rankings/players",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = PlayerRanking::class.java,
    )

fun ClashOfClans.playerBuilderBaseRanking(request: PlayerBuilderBaseRankingRequest): List<PlayerBuilderBaseRanking> =
    executeList(
        "GET",
        "/locations/${request.locationId}/rankings/players-builder-base",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = PlayerBuilderBaseRanking::class.java,
    )

fun ClashOfClans.clanBuilderBaseRanking(request: ClanBuilderBaseRankingRequest): List<ClanBuilderBaseRanking> =
    executeList(
        "GET",
        "/locations/${request.locationId}/rankings/clans-builder-base",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = ClanBuilderBaseRanking::class.java,
    )

fun ClashOfClans.clanCapitalRanking(request: ClanCapitalRankingRequest): List<ClanCapitalRanking> =
    executeList(
        "GET",
        "/locations/${request.locationId}/rankings/capitals",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = ClanCapitalRanking::class.java,
    )

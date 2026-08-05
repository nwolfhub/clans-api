package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.BuilderBaseLeague
import org.nwolfhub.lib.response.CapitalLeague
import org.nwolfhub.lib.response.League
import org.nwolfhub.lib.response.LeagueGroup
import org.nwolfhub.lib.response.LeagueSeason
import org.nwolfhub.lib.response.LeagueTier
import org.nwolfhub.lib.response.PlayerRanking
import org.nwolfhub.lib.response.WarLeague

class LeagueRequest(
    val leagueId: String,
)

class LeagueTierRequest(
    val leagueTierId: String,
)

class LeaguesRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class LeagueTiersRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class CapitalLeagueRequest(
    val leagueId: String,
)

class CapitalLeaguesRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class BuilderBaseLeagueRequest(
    val leagueId: String,
)

class BuilderBaseLeaguesRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class WarLeagueRequest(
    val leagueId: String,
)

class WarLeaguesRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class LeagueSeasonsRequest(
    val leagueId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class LeagueSeasonRankingsRequest(
    val leagueId: String,
    val seasonId: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class LeagueGroupRequest(
    val leagueGroupTag: String,
    val leagueSeasonId: String,
)

fun ClashOfClans.league(request: LeagueRequest): League =
    execute("GET", "/leagues/${request.leagueId}", clazz = League::class.java)

fun ClashOfClans.leagues(request: LeaguesRequest): List<League> =
    executeList("GET", "/leagues", queryParams(page(request.limit, request.after, request.before)), elementClass = League::class.java)

fun ClashOfClans.leagueTier(request: LeagueTierRequest): LeagueTier =
    execute("GET", "/leaguetiers/${request.leagueTierId}", clazz = LeagueTier::class.java)

fun ClashOfClans.leagueTiers(request: LeagueTiersRequest): List<LeagueTier> =
    executeList("GET", "/leaguetiers", queryParams(page(request.limit, request.after, request.before)), elementClass = LeagueTier::class.java)

fun ClashOfClans.capitalLeague(request: CapitalLeagueRequest): CapitalLeague =
    execute("GET", "/capitalleagues/${request.leagueId}", clazz = CapitalLeague::class.java)

fun ClashOfClans.capitalLeagues(request: CapitalLeaguesRequest): List<CapitalLeague> =
    executeList("GET", "/capitalleagues", queryParams(page(request.limit, request.after, request.before)), elementClass = CapitalLeague::class.java)

fun ClashOfClans.builderBaseLeague(request: BuilderBaseLeagueRequest): BuilderBaseLeague =
    execute("GET", "/builderbaseleagues/${request.leagueId}", clazz = BuilderBaseLeague::class.java)

fun ClashOfClans.builderBaseLeagues(request: BuilderBaseLeaguesRequest): List<BuilderBaseLeague> =
    executeList("GET", "/builderbaseleagues", queryParams(page(request.limit, request.after, request.before)), elementClass = BuilderBaseLeague::class.java)

fun ClashOfClans.warLeague(request: WarLeagueRequest): WarLeague =
    execute("GET", "/warleagues/${request.leagueId}", clazz = WarLeague::class.java)

fun ClashOfClans.warLeagues(request: WarLeaguesRequest): List<WarLeague> =
    executeList("GET", "/warleagues", queryParams(page(request.limit, request.after, request.before)), elementClass = WarLeague::class.java)

fun ClashOfClans.leagueSeasons(request: LeagueSeasonsRequest): List<LeagueSeason> =
    executeList(
        "GET",
        "/leagues/${request.leagueId}/seasons",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = LeagueSeason::class.java,
    )

fun ClashOfClans.leagueSeasonRankings(request: LeagueSeasonRankingsRequest): List<PlayerRanking> =
    executeList(
        "GET",
        "/leagues/${request.leagueId}/seasons/${request.seasonId}",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = PlayerRanking::class.java,
    )

fun ClashOfClans.leagueGroup(request: LeagueGroupRequest): LeagueGroup =
    execute(
        "GET",
        "/leaguegroup/${request.leagueGroupTag}/${request.leagueSeasonId}",
        clazz = LeagueGroup::class.java,
    )

package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.tag
import org.nwolfhub.lib.response.BuilderBaseLeague
import org.nwolfhub.lib.response.CapitalLeague
import org.nwolfhub.lib.response.League
import org.nwolfhub.lib.response.LeagueGroup
import org.nwolfhub.lib.response.LeagueSeason
import org.nwolfhub.lib.response.LeagueTier
import org.nwolfhub.lib.response.PlayerRanking
import org.nwolfhub.lib.response.WarLeague

fun ClashOfClans.league(leagueId: String): League =
    execute("GET", "/leagues/$leagueId", clazz = League::class.java)

fun ClashOfClans.leagues(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<League> =
    executeList("GET", "/leagues", queryParams(page(limit, after, before)), elementClass = League::class.java)

fun ClashOfClans.leagueTier(leagueTierId: String): LeagueTier =
    execute("GET", "/leaguetiers/$leagueTierId", clazz = LeagueTier::class.java)

fun ClashOfClans.leagueTiers(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<LeagueTier> =
    executeList("GET", "/leaguetiers", queryParams(page(limit, after, before)), elementClass = LeagueTier::class.java)

fun ClashOfClans.capitalLeague(leagueId: String): CapitalLeague =
    execute("GET", "/capitalleagues/$leagueId", clazz = CapitalLeague::class.java)

fun ClashOfClans.capitalLeagues(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<CapitalLeague> =
    executeList("GET", "/capitalleagues", queryParams(page(limit, after, before)), elementClass = CapitalLeague::class.java)

fun ClashOfClans.builderBaseLeague(leagueId: String): BuilderBaseLeague =
    execute("GET", "/builderbaseleagues/$leagueId", clazz = BuilderBaseLeague::class.java)

fun ClashOfClans.builderBaseLeagues(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<BuilderBaseLeague> =
    executeList("GET", "/builderbaseleagues", queryParams(page(limit, after, before)), elementClass = BuilderBaseLeague::class.java)

fun ClashOfClans.warLeague(leagueId: String): WarLeague =
    execute("GET", "/warleagues/$leagueId", clazz = WarLeague::class.java)

fun ClashOfClans.warLeagues(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<WarLeague> =
    executeList("GET", "/warleagues", queryParams(page(limit, after, before)), elementClass = WarLeague::class.java)

fun ClashOfClans.leagueSeasons(
    leagueId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<LeagueSeason> =
    executeList(
        "GET",
        "/leagues/$leagueId/seasons",
        queryParams(page(limit, after, before)),
        elementClass = LeagueSeason::class.java,
    )

fun ClashOfClans.leagueSeasonRankings(
    leagueId: String,
    seasonId: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<PlayerRanking> =
    executeList(
        "GET",
        "/leagues/$leagueId/seasons/$seasonId",
        queryParams(page(limit, after, before)),
        elementClass = PlayerRanking::class.java,
    )

fun ClashOfClans.leagueGroup(leagueGroupTag: String, leagueSeasonId: String): LeagueGroup =
    execute(
        "GET",
        "/leaguegroup/${leagueGroupTag.tag()}/$leagueSeasonId",
        clazz = LeagueGroup::class.java,
    )

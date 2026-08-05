package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.tag
import org.nwolfhub.lib.response.BattleLogEntry
import org.nwolfhub.lib.response.LeagueSeasonResult
import org.nwolfhub.lib.response.Player
import org.nwolfhub.lib.response.VerifyTokenResponse

class PlayerRequest(
    val playerTag: String,
)

class BattleLogRequest(
    val playerTag: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class LeagueHistoryRequest(
    val playerTag: String,
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class VerifyTokenRequest(
    val playerTag: String,
    val token: String,
)

fun ClashOfClans.player(request: PlayerRequest): Player =
    execute("GET", "/players/${request.playerTag.tag()}", clazz = Player::class.java)

fun ClashOfClans.battleLog(request: BattleLogRequest): List<BattleLogEntry> =
    executeList(
        "GET",
        "/players/${request.playerTag.tag()}/battlelog",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = BattleLogEntry::class.java,
    )

fun ClashOfClans.leagueHistory(request: LeagueHistoryRequest): List<LeagueSeasonResult> =
    executeList(
        "GET",
        "/players/${request.playerTag.tag()}/leaguehistory",
        queryParams(page(request.limit, request.after, request.before)),
        elementClass = LeagueSeasonResult::class.java,
    )

fun ClashOfClans.verifyToken(request: VerifyTokenRequest): VerifyTokenResponse =
    execute(
        "POST",
        "/players/${request.playerTag.tag()}/verifytoken",
        body = jsonBody(mapOf("token" to request.token)),
        clazz = VerifyTokenResponse::class.java,
    )

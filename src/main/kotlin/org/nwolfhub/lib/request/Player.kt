package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.tag
import org.nwolfhub.lib.response.BattleLogEntry
import org.nwolfhub.lib.response.LeagueSeasonResult
import org.nwolfhub.lib.response.Player
import org.nwolfhub.lib.response.VerifyTokenResponse

fun ClashOfClans.player(playerTag: String): Player =
    execute("GET", "/players/${playerTag.tag()}", clazz = Player::class.java)

fun ClashOfClans.battleLog(
    playerTag: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<BattleLogEntry> =
    executeList(
        "GET",
        "/players/${playerTag.tag()}/battlelog",
        queryParams(page(limit, after, before)),
        elementClass = BattleLogEntry::class.java,
    )

fun ClashOfClans.leagueHistory(
    playerTag: String,
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<LeagueSeasonResult> =
    executeList(
        "GET",
        "/players/${playerTag.tag()}/leaguehistory",
        queryParams(page(limit, after, before)),
        elementClass = LeagueSeasonResult::class.java,
    )

fun ClashOfClans.verifyToken(playerTag: String, token: String): VerifyTokenResponse =
    execute(
        "POST",
        "/players/${playerTag.tag()}/verifytoken",
        body = jsonBody(mapOf("token" to token)),
        clazz = VerifyTokenResponse::class.java,
    )

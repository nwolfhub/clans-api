package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.Label

class PlayerLabelsRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

class ClanLabelsRequest(
    val limit: Int? = null,
    val after: String? = null,
    val before: String? = null,
)

fun ClashOfClans.playerLabels(request: PlayerLabelsRequest): List<Label> =
    executeList("GET", "/labels/players", queryParams(page(request.limit, request.after, request.before)), elementClass = Label::class.java)

fun ClashOfClans.clanLabels(request: ClanLabelsRequest): List<Label> =
    executeList("GET", "/labels/clans", queryParams(page(request.limit, request.after, request.before)), elementClass = Label::class.java)

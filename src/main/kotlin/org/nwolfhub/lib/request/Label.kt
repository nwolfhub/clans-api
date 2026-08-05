package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.Label

fun ClashOfClans.playerLabels(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<Label> =
    executeList("GET", "/labels/players", queryParams(page(limit, after, before)), elementClass = Label::class.java)

fun ClashOfClans.clanLabels(
    limit: Int? = null,
    after: String? = null,
    before: String? = null,
): List<Label> =
    executeList("GET", "/labels/clans", queryParams(page(limit, after, before)), elementClass = Label::class.java)

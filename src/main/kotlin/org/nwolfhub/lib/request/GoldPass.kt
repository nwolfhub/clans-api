package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.GoldPassSeason

fun ClashOfClans.currentGoldPassSeason(): GoldPassSeason =
    execute("GET", "/goldpass/seasons/current", clazz = GoldPassSeason::class.java)

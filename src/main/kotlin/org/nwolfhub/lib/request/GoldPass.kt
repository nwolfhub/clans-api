package org.nwolfhub.lib.request

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.response.GoldPassSeason

class CurrentGoldPassSeasonRequest

fun ClashOfClans.currentGoldPassSeason(request: CurrentGoldPassSeasonRequest): GoldPassSeason =
    execute("GET", "/goldpass/seasons/current", clazz = GoldPassSeason::class.java)

package org.nwolfhub.lib.demo

import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.request.player
import kotlin.system.exitProcess

private const val envName = "COC_TOKEN"

fun main() {
    val token = System.getenv(envName)

    if(token == null) {
        println("$envName is missing, aborting")
        exitProcess(1)
    }

    val client = ClashOfClans(token)

    val player = client.player("Q0P2PURGQ")

    println("Player name: ${player.name}")
}
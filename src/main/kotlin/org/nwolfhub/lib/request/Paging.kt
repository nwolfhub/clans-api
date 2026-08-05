package org.nwolfhub.lib.request

fun queryParams(vararg maps: Map<String, String>): Map<String, String> =
    maps.flatMap { it.entries }.associate { it.key to it.value }

fun page(limit: Int?, after: String?, before: String?): Map<String, String> =
    listOfNotNull(
        limit?.let { "limit" to it.toString() },
        after?.let { "after" to it },
        before?.let { "before" to it },
    ).toMap()

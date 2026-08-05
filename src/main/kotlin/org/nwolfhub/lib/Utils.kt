package org.nwolfhub.lib

fun String.tag(): String = if (startsWith('#')) this else "#$this"
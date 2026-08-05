package org.nwolfhub.lib.spring

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "clash.of.clans")
data class ClashProperties(
    val token: String
)
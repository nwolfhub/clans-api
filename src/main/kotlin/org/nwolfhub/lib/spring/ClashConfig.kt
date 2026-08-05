package org.nwolfhub.lib.spring

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(ClashProperties::class)
class ClashConfig

@ConfigurationProperties(prefix = "clash.of.clans")
data class ClashProperties(
    val token: String
)
package org.nwolfhub.lib.spring

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.nwolfhub.lib.client.ClashOfClans
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@AutoConfiguration
@ConditionalOnProperty("clash.of.clans.token")
class ClashClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun clashClient(
        properties: ClashProperties,
        okHttpProvider: ObjectProvider<OkHttpClient>,
        objectMapperProvider: ObjectProvider<ObjectMapper>,
    ): ClashOfClans {
        val customOkHttp: OkHttpClient? = okHttpProvider.getIfAvailable()
        val customObjectMapper: ObjectMapper? = objectMapperProvider.getIfAvailable()

        if (customOkHttp == null && customObjectMapper == null) {
            return ClashOfClans(properties.token)
        }

        return ClashOfClans(properties.token)
            .apply {
                customOkHttp?.let { this.client = it }
                customObjectMapper?.let { this.json = it }
            }
    }

    @Configuration
    @EnableConfigurationProperties(ClashProperties::class)
    class ClashConfig
}
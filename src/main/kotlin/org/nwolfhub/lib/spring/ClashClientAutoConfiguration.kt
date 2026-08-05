package org.nwolfhub.lib.spring

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.nwolfhub.lib.client.ClashOfClans
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnBean(ClashConfig::class)
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
}
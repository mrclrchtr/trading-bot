package de.mrclrchtr.trading.bot.configuration

import de.mrclrchtr.trading.bot.generated.swagger.client.ApiClient
import org.springframework.beans.BeansException
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class ApiClientConfiguration : BeanPostProcessor {

    @Value("\${bot.api.base-uri}")
    lateinit var baseUri: String

    @Throws(BeansException::class)
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
        if (bean is ApiClient) {
            bean.basePath = baseUri
        }
        return bean
    }

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.build()
    }

}
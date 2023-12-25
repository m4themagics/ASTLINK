package com.astlink.apigateway

import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableDiscoveryClient
@SpringBootApplication
class ApiGatewayApplication {

    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route { r ->
                r.path("/some-service/**")
                    .uri("lb://SOME-SERVICE")
            }
            .build()
    }
}

fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}

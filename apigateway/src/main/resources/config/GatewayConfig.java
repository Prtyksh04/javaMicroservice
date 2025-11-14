package com.ncu.college.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("userservice", r -> r.path("/user/**")
                        .uri("lb://userservice"))
                .route("movieservice", r -> r.path("/movie/**")
                        .uri("lb://movieservice"))
                .route("ticketbookingservice", r -> r.path("/ticket/**")
                        .uri("lb://ticketbookingservice"))
                .build();
    }

}

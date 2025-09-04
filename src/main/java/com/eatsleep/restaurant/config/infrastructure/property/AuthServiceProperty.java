package com.eatsleep.restaurant.config.infrastructure.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("route.services.auth")
public record AuthServiceProperty(
        String url) {
}

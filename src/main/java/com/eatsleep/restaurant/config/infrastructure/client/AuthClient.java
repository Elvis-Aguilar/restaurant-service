package com.eatsleep.restaurant.config.infrastructure.client;

import com.eatsleep.restaurant.config.infrastructure.web.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gatekeeper", url = "${client.services.auth-identity}/api/auth-identity")
public interface AuthClient {

    @GetMapping("/v1/user/current")
    UserDto findCurrentUser();
}
package com.eatsleep.restaurant.order.infrastructure.outputadapter.client.rest;

import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "auth-identity", url = "${client.services.auth-identity}/api/auth-identity")
public interface CustomerRestClient {

    @GetMapping("/v1/customers/{id}")
    CustomerResponseDto  getCustomerById(@PathVariable UUID id);
}

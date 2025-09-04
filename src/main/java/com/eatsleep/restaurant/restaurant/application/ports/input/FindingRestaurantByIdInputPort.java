package com.eatsleep.restaurant.restaurant.application.ports.input;

import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;

import java.util.UUID;

public interface FindingRestaurantByIdInputPort {
    RestaurantDomainEntity findingRestaurantById(UUID restaurantId);
}

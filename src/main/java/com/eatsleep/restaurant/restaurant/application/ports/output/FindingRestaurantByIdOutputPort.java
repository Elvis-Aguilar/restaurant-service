package com.eatsleep.restaurant.restaurant.application.ports.output;

import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;

import java.util.UUID;

public interface FindingRestaurantByIdOutputPort {
    RestaurantDomainEntity findingRestaurantById(UUID restaurantId);
}

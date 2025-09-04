package com.eatsleep.restaurant.restaurant.application.ports.output;

import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;

import java.util.List;

public interface FindingAllRestaurantOutputPort {
    List<RestaurantDomainEntity> findAllRestaurants();
}

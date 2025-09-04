package com.eatsleep.restaurant.restaurant.application.ports.input;

import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;

import java.util.List;

public interface ListAllRestaurantInputPort {
    List<RestaurantDomainEntity> listAllRestaurants();
}

package com.eatsleep.restaurant.dishes.application.ports.input;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ListAllDishesByRestaurantIdtInputPort {

    List<DishesDomainEntity> findAllDishesByRestaurantId(UUID restaurantId);
}

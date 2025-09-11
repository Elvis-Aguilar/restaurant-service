package com.eatsleep.restaurant.dishes.application.ports.input;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ListAllDishesInputPort {
    List<DishesDomainEntity> findAllDishes();
}

package com.eatsleep.restaurant.dishes.application.ports.output;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;

import java.util.UUID;

public interface FindingDishesByIdOutputPort {
    DishesDomainEntity findDishesById(UUID id);
}

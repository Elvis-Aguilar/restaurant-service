package com.eatsleep.restaurant.dishes.application.ports.input;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;

import java.util.UUID;

public interface FindingDishesByIdInputPort {
    DishesDomainEntity findingDishesById(UUID id);
}

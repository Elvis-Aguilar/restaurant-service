package com.eatsleep.restaurant.dishes.application.ports.output;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ValidDishesIdOutputPort {
    List<DishesDomainEntity> validDishesId(List<UUID> dishesId);
}

package com.eatsleep.restaurant.restaurant.application.usecase;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.restaurant.application.ports.input.FindingRestaurantByIdInputPort;
import com.eatsleep.restaurant.restaurant.application.ports.output.FindingRestaurantByIdOutputPort;
import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindRestaurantByIdCase implements FindingRestaurantByIdInputPort {

    private final FindingRestaurantByIdOutputPort findingRestaurantByIdOutputPort;

    @Override
    public RestaurantDomainEntity findingRestaurantById(UUID restaurantId) {
        return findingRestaurantByIdOutputPort.findingRestaurantById(restaurantId);
    }
}

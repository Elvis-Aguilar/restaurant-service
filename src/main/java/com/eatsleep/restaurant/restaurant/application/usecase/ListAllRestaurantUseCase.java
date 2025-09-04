package com.eatsleep.restaurant.restaurant.application.usecase;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.restaurant.application.ports.input.ListAllRestaurantInputPort;
import com.eatsleep.restaurant.restaurant.application.ports.output.FindingAllRestaurantOutputPort;
import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListAllRestaurantUseCase implements ListAllRestaurantInputPort {

    private final FindingAllRestaurantOutputPort  findingAllRestaurantOutputPort;

    @Override
    public List<RestaurantDomainEntity> listAllRestaurants() {
        return findingAllRestaurantOutputPort.findAllRestaurants();
    }
}

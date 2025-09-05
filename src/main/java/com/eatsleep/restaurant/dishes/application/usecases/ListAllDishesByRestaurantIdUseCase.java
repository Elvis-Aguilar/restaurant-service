package com.eatsleep.restaurant.dishes.application.usecases;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.dishes.application.ports.input.ListAllDishesByRestaurantIdtInputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesByRestaurantIdOutputPort;
import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class ListAllDishesByRestaurantIdUseCase implements ListAllDishesByRestaurantIdtInputPort {

    private final FindingAllDishesByRestaurantIdOutputPort findingAllDishesByRestaurantIdOutputPort;

    @Override
    public List<DishesDomainEntity> findAllDishesByRestaurantId(UUID restaurantId) {
        return findingAllDishesByRestaurantIdOutputPort.findAllDishesByRestaurantId(restaurantId);
    }
}

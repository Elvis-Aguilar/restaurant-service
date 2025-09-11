package com.eatsleep.restaurant.dishes.application.usecases;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.dishes.application.ports.input.ListAllDishesByRestaurantIdtInputPort;
import com.eatsleep.restaurant.dishes.application.ports.input.ListAllDishesInputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesByRestaurantIdOutputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesOutputPort;
import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class ListAllDishesUseCase implements ListAllDishesInputPort {

    private final FindingAllDishesOutputPort outputPort;

    @Override
    public List<DishesDomainEntity> findAllDishes() {
        return outputPort.findAllDishes();
    }
}

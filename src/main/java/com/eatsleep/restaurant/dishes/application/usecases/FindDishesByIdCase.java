package com.eatsleep.restaurant.dishes.application.usecases;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.dishes.application.ports.input.FindingDishesByIdInputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingDishesByIdOutputPort;
import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindDishesByIdCase implements FindingDishesByIdInputPort {

    private final FindingDishesByIdOutputPort findDishesByIdOutputPort;

    @Override
    public DishesDomainEntity findingDishesById(UUID id) {
        return findDishesByIdOutputPort.findDishesById(id);
    }
}

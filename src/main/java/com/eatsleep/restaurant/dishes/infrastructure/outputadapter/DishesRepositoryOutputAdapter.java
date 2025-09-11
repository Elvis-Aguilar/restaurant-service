package com.eatsleep.restaurant.dishes.infrastructure.outputadapter;

import com.eatsleep.restaurant.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.restaurant.common.infrastructure.exception.BadRequestException;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesByRestaurantIdOutputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesOutputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingDishesByIdOutputPort;
import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.entity.DishesDBEntity;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.mapper.DishesPersistenceMapper;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.repository.DishesDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class DishesRepositoryOutputAdapter implements FindingAllDishesByRestaurantIdOutputPort, FindingDishesByIdOutputPort,
        FindingAllDishesOutputPort {

    private final DishesDBRepository dishesDBRepository;
    private final DishesPersistenceMapper mapper;

    @Override
    public List<DishesDomainEntity> findAllDishesByRestaurantId(UUID restaurantId) {
        return dishesDBRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(mapper::ToDishesDomainEntity)
                .toList();
    }

    @Override
    public DishesDomainEntity findDishesById(UUID id) {
        DishesDBEntity dishesDBEntity = dishesDBRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Platillo con id" + id + " no encontrado"));
        return mapper.ToDishesDomainEntity(dishesDBEntity);
    }

    @Override
    public List<DishesDomainEntity> findAllDishes() {
        return dishesDBRepository.findAll()
                .stream()
                .map(mapper::ToDishesDomainEntity)
                .toList();
    }
}

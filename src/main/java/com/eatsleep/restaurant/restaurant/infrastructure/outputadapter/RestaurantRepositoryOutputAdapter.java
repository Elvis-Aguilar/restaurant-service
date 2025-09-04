package com.eatsleep.restaurant.restaurant.infrastructure.outputadapter;

import com.eatsleep.restaurant.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.restaurant.common.infrastructure.exception.BadRequestException;
import com.eatsleep.restaurant.restaurant.application.ports.output.FindingAllRestaurantOutputPort;
import com.eatsleep.restaurant.restaurant.application.ports.output.FindingRestaurantByIdOutputPort;
import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity.RestaurantDBEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.mapper.RestaurantPersistenceMapper;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.repository.RestaurantDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RestaurantRepositoryOutputAdapter implements FindingRestaurantByIdOutputPort, FindingAllRestaurantOutputPort {

    private final RestaurantDBRepository restaurantDBRepository;
    private final RestaurantPersistenceMapper mapper;

    @Override
    public List<RestaurantDomainEntity> findAllRestaurants() {
        return restaurantDBRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public RestaurantDomainEntity findingRestaurantById(UUID restaurantId) {
        RestaurantDBEntity entity = restaurantDBRepository.findById(restaurantId)
                .orElseThrow(() -> new BadRequestException("Restaurante con id " + restaurantId + " no encontrado"));

        return mapper.toDomain(entity) ;
    }
}

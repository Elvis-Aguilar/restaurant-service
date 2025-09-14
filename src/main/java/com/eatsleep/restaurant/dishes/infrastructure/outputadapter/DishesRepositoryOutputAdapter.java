package com.eatsleep.restaurant.dishes.infrastructure.outputadapter;

import com.eatsleep.restaurant.common.application.exception.EntityNotFount;
import com.eatsleep.restaurant.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.restaurant.common.infrastructure.exception.BadRequestException;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesByRestaurantIdOutputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingAllDishesOutputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.FindingDishesByIdOutputPort;
import com.eatsleep.restaurant.dishes.application.ports.output.ValidDishesIdOutputPort;
import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.entity.DishesDBEntity;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.mapper.DishesPersistenceMapper;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.repository.DishesDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class DishesRepositoryOutputAdapter implements FindingAllDishesByRestaurantIdOutputPort, FindingDishesByIdOutputPort,
        FindingAllDishesOutputPort, ValidDishesIdOutputPort {

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

    @Override
    public List<DishesDomainEntity> validDishesId(List<UUID> dishesId) {
        if (dishesId == null || dishesId.isEmpty()) {
            throw new EntityNotFount("La lista de IDs de platillos no puede estar vacía.");
        }

        // Obtiene los platos que existen en BD
        List<DishesDBEntity> existingDishes = dishesDBRepository.findAllById(dishesId);

        // Extrae solo los IDs existentes
        Set<UUID> existingIds = existingDishes.stream()
                .map(DishesDBEntity::getId)
                .collect(Collectors.toSet());

        // Filtra los que no existen
        List<UUID> notFound = dishesId.stream()
                .filter(id -> !existingIds.contains(id))
                .toList();

        if (!notFound.isEmpty()) {
            throw new EntityNotFount("Platillos no encontrados: " + notFound);
        }

        // Mapear a dominio
        return existingDishes.stream()
                .map(mapper::ToDishesDomainEntity)
                .toList();
    }



}

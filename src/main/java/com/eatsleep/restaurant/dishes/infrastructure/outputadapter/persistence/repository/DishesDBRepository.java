package com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.entity.DishesDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishesDBRepository extends JpaRepository<DishesDBEntity, UUID> {

    List<DishesDBEntity> findByRestaurantId(UUID restaurantId);
}

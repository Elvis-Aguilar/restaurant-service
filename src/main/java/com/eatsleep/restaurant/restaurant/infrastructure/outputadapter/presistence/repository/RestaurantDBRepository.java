package com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.repository;

import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity.RestaurantDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantDBRepository extends JpaRepository<RestaurantDBEntity, UUID> {
}

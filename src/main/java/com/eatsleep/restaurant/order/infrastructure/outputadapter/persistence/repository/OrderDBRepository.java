package com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity.OrderDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDBRepository extends JpaRepository<OrderDBEntity, UUID> {

    List<OrderDBEntity> findAllByRestaurantId(UUID restaurantId);
}

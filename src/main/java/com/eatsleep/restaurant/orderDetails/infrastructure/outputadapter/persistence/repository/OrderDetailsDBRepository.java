package com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.entity.OrderDetailsDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDetailsDBRepository extends JpaRepository<OrderDetailsDBEntity, UUID> {
    List<OrderDetailsDBEntity> findAllByOrderId(UUID orderId);
}

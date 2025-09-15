package com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity.OrderDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDBRepository extends JpaRepository<OrderDBEntity, UUID> {

    List<OrderDBEntity> findAllByRestaurantId(UUID restaurantId);

    @Query("""
    SELECT p
    FROM order p
     WHERE p.restaurant.id = :restaurantId
      AND p.createdAt >= :startDate
      AND p.createdAt <= :endDate
    """)
    List<OrderDBEntity> findAllByIdAndDateRange(
            @Param("restaurantId") UUID restaurantId,
            @Param("startDate") Instant startDate,
            @Param("endDate") Instant endDate
    );


}

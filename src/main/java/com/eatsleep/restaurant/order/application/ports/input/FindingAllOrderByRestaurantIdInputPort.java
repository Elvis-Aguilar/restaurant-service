package com.eatsleep.restaurant.order.application.ports.input;

import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingAllOrderByRestaurantIdInputPort {
    List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId);
}

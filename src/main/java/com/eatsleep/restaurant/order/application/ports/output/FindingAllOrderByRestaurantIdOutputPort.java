package com.eatsleep.restaurant.order.application.ports.output;

import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingAllOrderByRestaurantIdOutputPort {
    List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId);

}

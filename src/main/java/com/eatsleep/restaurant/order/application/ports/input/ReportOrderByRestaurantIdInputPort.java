package com.eatsleep.restaurant.order.application.ports.input;

import com.eatsleep.restaurant.order.application.usecase.RangeDateCaseDto;
import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ReportOrderByRestaurantIdInputPort {
    List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId, RangeDateCaseDto range);
}

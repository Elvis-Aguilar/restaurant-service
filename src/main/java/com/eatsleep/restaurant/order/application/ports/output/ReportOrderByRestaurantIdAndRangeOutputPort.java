package com.eatsleep.restaurant.order.application.ports.output;

import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ReportOrderByRestaurantIdAndRangeOutputPort {
    List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId, LocalDate startDate, LocalDate endDate);

}

package com.eatsleep.restaurant.orderDetails.application.ports.output;

import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingAllDetailsByOrderIdOutputPort {
    List<OrderDetailsDomainEntity> findAllByOrderId(UUID orderId);
}

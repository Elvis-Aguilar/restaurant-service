package com.eatsleep.restaurant.orderDetails.application.ports.output;

import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;

import java.util.List;

public interface StoringAllDetailsOutputPort {
    void storingAllDetails(List<OrderDetailsDomainEntity> orderDetails);
}

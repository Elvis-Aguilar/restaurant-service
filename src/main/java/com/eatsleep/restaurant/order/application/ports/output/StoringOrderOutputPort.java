package com.eatsleep.restaurant.order.application.ports.output;

import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;

public interface StoringOrderOutputPort {
    OrderDomainEntity saveOrder(OrderDomainEntity orderDomainEntity);
}

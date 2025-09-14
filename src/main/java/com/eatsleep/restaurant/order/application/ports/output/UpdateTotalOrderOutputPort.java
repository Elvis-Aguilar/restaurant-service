package com.eatsleep.restaurant.order.application.ports.output;

import java.math.BigDecimal;
import java.util.UUID;

public interface UpdateTotalOrderOutputPort {
    void  updateTotalOrder(UUID orderId, BigDecimal totalPrice);
}

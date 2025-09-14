package com.eatsleep.restaurant.order.infrastructure.inputadapter.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record DetailsResponseDto(
        UUID id,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal unitCost,
        BigDecimal subtotal,
        BigDecimal discountPercentage,
        UUID promotionId,
        UUID orderId,
        UUID dishId,
        String dishName
) {
}

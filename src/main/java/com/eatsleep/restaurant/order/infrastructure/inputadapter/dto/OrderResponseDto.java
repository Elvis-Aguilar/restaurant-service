package com.eatsleep.restaurant.order.infrastructure.inputadapter.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
public record OrderResponseDto(
        UUID id,
        UUID customerId,
        BigDecimal totalPrice,
        BigDecimal discountPercentage,
        UUID promotionId,
        Instant createdAt,
        UUID restaurantId,
        String restaurantName,
        List<DetailsResponseDto> details
) {
}

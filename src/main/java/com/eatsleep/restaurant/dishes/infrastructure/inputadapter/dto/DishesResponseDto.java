package com.eatsleep.restaurant.dishes.infrastructure.inputadapter.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record DishesResponseDto(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        String restaurantName
) {
}

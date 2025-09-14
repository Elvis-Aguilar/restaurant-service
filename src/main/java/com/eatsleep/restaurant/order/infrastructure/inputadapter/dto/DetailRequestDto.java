package com.eatsleep.restaurant.order.infrastructure.inputadapter.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class DetailRequestDto {

    @NotNull
    UUID dishId;

    @Positive
    Integer quantity;

    @PositiveOrZero
    BigDecimal discountPercentage;
}

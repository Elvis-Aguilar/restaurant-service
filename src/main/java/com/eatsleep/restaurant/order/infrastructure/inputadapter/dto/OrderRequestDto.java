package com.eatsleep.restaurant.order.infrastructure.inputadapter.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Value
public class OrderRequestDto {

    @NotNull
    UUID customerId;

    @NotNull
    UUID restaurantId;

    @PositiveOrZero
    BigDecimal discountPercentage;

    List<DetailRequestDto> detailRequestDtoList;
}

package com.eatsleep.restaurant.orderDetails.application.usecase;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@AllArgsConstructor
public class CreatDetailsDto {
    UUID dishId;
    Integer quantity;
    BigDecimal discountPercentage;
}

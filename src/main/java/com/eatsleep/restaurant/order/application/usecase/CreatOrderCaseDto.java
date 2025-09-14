package com.eatsleep.restaurant.order.application.usecase;

import com.eatsleep.restaurant.orderDetails.application.usecase.CreatDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Value
@AllArgsConstructor
public class CreatOrderCaseDto {
    UUID customerId;
    UUID restaurantId;
    BigDecimal discountPercentage;
    List<CreatDetailsDto> details;
}

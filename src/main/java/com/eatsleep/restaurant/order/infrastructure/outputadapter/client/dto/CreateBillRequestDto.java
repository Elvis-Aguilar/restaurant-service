package com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBillRequestDto {
    UUID refenceId;
    String typeReference;
    BigDecimal amount;
}

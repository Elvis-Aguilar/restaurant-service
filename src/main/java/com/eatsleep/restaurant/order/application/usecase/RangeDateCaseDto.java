package com.eatsleep.restaurant.order.application.usecase;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class RangeDateCaseDto {
    LocalDate startDate;
    LocalDate endDate;
}

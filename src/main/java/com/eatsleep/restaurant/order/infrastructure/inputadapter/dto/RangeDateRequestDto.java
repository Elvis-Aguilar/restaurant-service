package com.eatsleep.restaurant.order.infrastructure.inputadapter.dto;

import com.eatsleep.restaurant.order.application.usecase.RangeDateCaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDate;

@Value
public class RangeDateRequestDto {
    @NotBlank
    String startDate;
    @NotBlank
    String endDate;

    public RangeDateCaseDto toCase(){
        return new RangeDateCaseDto(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}

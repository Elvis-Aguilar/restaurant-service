package com.eatsleep.restaurant.restaurant.infrastructure.inputadapter.dto;

import lombok.Builder;

import java.time.LocalTime;
import java.util.UUID;

@Builder(toBuilder = true)
public record RestaurantResponseDto(
        UUID id,
        String name,
        String address,
        String phone,
        Integer capacity,
        LocalTime openingTime,
        LocalTime closingTime,
        UUID hotelId
) {
}

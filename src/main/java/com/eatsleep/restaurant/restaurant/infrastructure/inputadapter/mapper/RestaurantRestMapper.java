package com.eatsleep.restaurant.restaurant.infrastructure.inputadapter.mapper;

import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.inputadapter.dto.RestaurantResponseDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantRestMapper {

    public RestaurantResponseDto toResponseDto(RestaurantDomainEntity entity){
        if (entity == null){ return null;}

        return RestaurantResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .capacity(entity.getCapacity())
                .hotelId(entity.getHotelId())
                .openingTime(entity.getOpeningTime())
                .closingTime(entity.getClosingTime())
                .build();
    }
}

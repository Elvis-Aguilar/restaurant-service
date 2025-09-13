package com.eatsleep.restaurant.dishes.infrastructure.inputadapter.mapper;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.dishes.infrastructure.inputadapter.dto.DishesResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DishesRestMapper {

    public DishesResponseDto toResponseDto(DishesDomainEntity  dishesDomainEntity) {
        if (dishesDomainEntity == null) {return null;}

        return DishesResponseDto.builder()
                .id(dishesDomainEntity.getId())
                .name(dishesDomainEntity.getName())
                .description(dishesDomainEntity.getDescription())
                .price(dishesDomainEntity.getPrice())
                .restaurantName(dishesDomainEntity.getRestaurantName())
                .cost(dishesDomainEntity.getCost())
                .build();
    }
}

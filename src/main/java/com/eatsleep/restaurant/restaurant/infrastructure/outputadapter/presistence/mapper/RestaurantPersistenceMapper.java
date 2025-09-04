package com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.mapper;

import com.eatsleep.restaurant.restaurant.domain.model.RestaurantDomainEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity.RestaurantDBEntity;
import org.springframework.stereotype.Component;

@Component
public class RestaurantPersistenceMapper {

    public RestaurantDomainEntity toDomain(RestaurantDBEntity  restaurantDBEntity) {
        if (restaurantDBEntity == null) {return null;}

        return new RestaurantDomainEntity(restaurantDBEntity.getId(),
                restaurantDBEntity.getName(),
                restaurantDBEntity.getAddress(),
                restaurantDBEntity.getOpeningTime(),
                restaurantDBEntity.getPhone(),
                restaurantDBEntity.getCapacity(),
                restaurantDBEntity.getClosingTime(),
                restaurantDBEntity.getHotelId());
    }
}

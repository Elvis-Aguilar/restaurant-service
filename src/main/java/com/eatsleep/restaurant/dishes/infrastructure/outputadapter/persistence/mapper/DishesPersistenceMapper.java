package com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.entity.DishesDBEntity;
import org.springframework.stereotype.Component;

@Component
public class DishesPersistenceMapper {

    public DishesDomainEntity ToDishesDomainEntity(DishesDBEntity dishesDBEntity) {
        if (dishesDBEntity == null) {return null;}

        return new DishesDomainEntity(dishesDBEntity.getId(),
                dishesDBEntity.getPrice(),
                dishesDBEntity.getDescription(),
                dishesDBEntity.getName(),
                dishesDBEntity.getRestaurant().getName());
    }
}

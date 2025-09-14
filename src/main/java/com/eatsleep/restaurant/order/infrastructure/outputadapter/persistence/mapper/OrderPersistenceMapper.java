package com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity.OrderDBEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity.RestaurantDBEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceMapper {

    private final EntityManager entityManager;

    public OrderDomainEntity toOrderDomainEntity(OrderDBEntity dbEntity) {
        return new OrderDomainEntity(dbEntity.getId(),
                dbEntity.getCustomerId(),
                dbEntity.getTotalPrice(),
                dbEntity.getDiscountPercentage(),
                dbEntity.getPromotionId(),
                dbEntity.getCreatedAt(),
                dbEntity.getRestaurant().getId(),
                dbEntity.getRestaurant().getName());
    }

    public OrderDBEntity toOrderDBEntity(OrderDomainEntity domainEntity, RestaurantDBEntity restaurantDBEntity) {
        return OrderDBEntity.builder()
                .totalPrice(domainEntity.getTotalPrice())
                .discountPercentage(domainEntity.getDiscountPercentage())
                .customerId(domainEntity.getCustomerId())
                .restaurant(restaurantDBEntity)
                .build();
    }
}

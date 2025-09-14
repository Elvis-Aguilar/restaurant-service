package com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.entity.DishesDBEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity.OrderDBEntity;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.entity.OrderDetailsDBEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DetailsPersistenceMapper {

    private final EntityManager entityManager;

    public OrderDetailsDBEntity toDBEntity(OrderDetailsDomainEntity orderDetails) {
        return OrderDetailsDBEntity.builder()
                .quantity(orderDetails.getQuantity())
                .unitPrice(orderDetails.getUnitPrice())
                .unitCost(orderDetails.getUnitCost())
                .subtotal(orderDetails.getSubtotal())
                .discountPercentage(orderDetails.getDiscountPercentage())
                .promotionId(orderDetails.getPromotionId())
                .order(entityManager.getReference(OrderDBEntity.class, orderDetails.getOrderId()))
                .dish(entityManager.getReference(DishesDBEntity.class, orderDetails.getDishId()))
                .build();
    }

    public OrderDetailsDomainEntity toDomain(OrderDetailsDBEntity orderDetails) {
        return new OrderDetailsDomainEntity(orderDetails.getId(),
                orderDetails.getQuantity(),
                orderDetails.getUnitPrice(),
                orderDetails.getUnitCost(),
                orderDetails.getSubtotal(),
                orderDetails.getDiscountPercentage(),
                orderDetails.getPromotionId(),
                orderDetails.getOrder().getId(),
                orderDetails.getDish().getId(),
                orderDetails.getDish().getName());
    }
}

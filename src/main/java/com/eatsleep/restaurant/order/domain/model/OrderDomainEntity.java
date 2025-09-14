package com.eatsleep.restaurant.order.domain.model;


import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class OrderDomainEntity {

    private UUID id;
    private UUID customerId;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;
    private Instant createdAt;
    private UUID restaurantId;
    private String restaurantName;
    private List<OrderDetailsDomainEntity> details;

    public OrderDomainEntity(UUID id, UUID customerId, BigDecimal totalPrice, BigDecimal discountPercentage, UUID promotionId, Instant createdAt, UUID restaurantId, String restaurantName) {
        this.id = id;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.discountPercentage = discountPercentage;
        this.promotionId = promotionId;
        this.createdAt = createdAt;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public OrderDomainEntity(BigDecimal totalPrice, BigDecimal discountPercentage, UUID promotionId, UUID restaurantId,UUID customerId ) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.totalPrice = totalPrice;
        this.discountPercentage = discountPercentage;
        this.promotionId = promotionId;
    }

    /**
     * Cálculo del total de la orden:
     * totalPrice = suma de subtotales de details - descuento (si existe)
     */
    public BigDecimal calculationTotalPrice() {
        if (details == null || details.isEmpty()) {
            this.totalPrice = BigDecimal.ZERO;
            return this.totalPrice;
        }

        // 1. sumar subtotales de los detalles
        BigDecimal sumSubtotals = details.stream()
                .map(OrderDetailsDomainEntity::getSubtotal)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 2. aplicar descuento a nivel de orden si existe
        BigDecimal finalTotal = sumSubtotals;
        if (discountPercentage != null && discountPercentage.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal discount = sumSubtotals
                    .multiply(discountPercentage)
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

            finalTotal = sumSubtotals.subtract(discount);
        }

        // 3. actualizar el campo totalPrice
        this.totalPrice = finalTotal.setScale(2, RoundingMode.HALF_UP);
        return this.totalPrice;
    }

}

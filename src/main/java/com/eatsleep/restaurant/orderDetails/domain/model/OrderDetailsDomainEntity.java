package com.eatsleep.restaurant.orderDetails.domain.model;

import com.eatsleep.restaurant.common.application.exception.InvalidPropertyEntityDomain;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Getter
public class OrderDetailsDomainEntity {

    private UUID id;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal unitCost;
    private BigDecimal subtotal;
    private BigDecimal discountPercentage;
    private UUID promotionId;
    private UUID orderId;
    private UUID dishId;
    private String dishName;


    public OrderDetailsDomainEntity(UUID id, Integer quantity, BigDecimal unitPrice, BigDecimal unitCost, BigDecimal subtotal, BigDecimal discountPercentage, UUID promotionId, UUID orderId, UUID dishId, String dishName) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.subtotal = subtotal;
        this.discountPercentage = discountPercentage;
        this.promotionId = promotionId;
        this.orderId = orderId;
        this.dishId = dishId;
        this.dishName = dishName;
        this.valid();
    }

    public OrderDetailsDomainEntity(UUID orderId, UUID dishId, Integer quantity, BigDecimal unitPrice, BigDecimal unitCost, BigDecimal discountPercentage) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.discountPercentage = discountPercentage;
        this.valid();
        this.calculateSubtotal();
    }


    /**
     * validaciones de domino
     */
    private void valid(){
        if (quantity < 1) {
            throw new InvalidPropertyEntityDomain("La cantidad no puede ser menor a 1");
        }

        if (unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPropertyEntityDomain("El precio unitario debe ser mayor a 0");
        }

        if (unitCost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPropertyEntityDomain("El cost debe ser mayor a 0");
        }

        if (discountPercentage == null ||
                discountPercentage.compareTo(BigDecimal.ZERO) < 0 ||
                discountPercentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidPropertyEntityDomain("El descuento debe estar entre 0 y 100");
        }
    }

    /**
     * Cálculo de subtotal:
     * subtotal = (cantidad * unitPrice) - descuento
     */
    private void calculateSubtotal() {

        // cantidad * unitPrice
        BigDecimal total = unitPrice.multiply(BigDecimal.valueOf(quantity));

        // calcular descuento si existe
        if (discountPercentage.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal discount = total.multiply(discountPercentage)
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            total = total.subtract(discount);
        }

        this.subtotal = total.setScale(2, RoundingMode.HALF_UP);
    }

}

package com.eatsleep.restaurant.dishes.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
public class DishesDomainEntity {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String restaurantName;

    public DishesDomainEntity(UUID id, BigDecimal price, String description, String name, String restaurantName) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
        this.restaurantName = restaurantName;
    }

    public DishesDomainEntity(BigDecimal price, String description, String name) {
        this.price = price;
        this.description = description;
        this.name = name;
    }
}

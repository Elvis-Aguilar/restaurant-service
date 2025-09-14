package com.eatsleep.restaurant.order.domain.model;


import lombok.Getter;

import java.util.UUID;

@Getter
public class CustomerDomainEntity {

    private UUID id;
    private String fullName;

    public CustomerDomainEntity(UUID id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}

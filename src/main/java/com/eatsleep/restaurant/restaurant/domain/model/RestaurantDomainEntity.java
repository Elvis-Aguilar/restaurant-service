package com.eatsleep.restaurant.restaurant.domain.model;

import lombok.Getter;

import java.time.LocalTime;
import java.util.UUID;

@Getter
public class RestaurantDomainEntity {

    private UUID id;
    private String name;
    private String address;
    private String phone;
    private Integer capacity;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private UUID hotelId;

    public RestaurantDomainEntity(UUID id, String name, String address, LocalTime openingTime, String phone, Integer capacity, LocalTime closingTime, UUID hotelId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingTime = openingTime;
        this.phone = phone;
        this.capacity = capacity;
        this.closingTime = closingTime;
        this.hotelId = hotelId;
    }

    public RestaurantDomainEntity(String name, String address, LocalTime openingTime, String phone, Integer capacity, LocalTime closingTime, UUID hotelId) {
        this.name = name;
        this.address = address;
        this.openingTime = openingTime;
        this.phone = phone;
        this.capacity = capacity;
        this.closingTime = closingTime;
        this.hotelId = hotelId;
    }
}

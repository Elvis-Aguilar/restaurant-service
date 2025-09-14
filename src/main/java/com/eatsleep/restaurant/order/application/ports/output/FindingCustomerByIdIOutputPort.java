package com.eatsleep.restaurant.order.application.ports.output;

import com.eatsleep.restaurant.order.domain.model.CustomerDomainEntity;

import java.util.UUID;

public interface FindingCustomerByIdIOutputPort {
    CustomerDomainEntity getCustomerById(UUID customerId);
}

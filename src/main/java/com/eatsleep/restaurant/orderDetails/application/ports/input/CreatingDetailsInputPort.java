package com.eatsleep.restaurant.orderDetails.application.ports.input;

import com.eatsleep.restaurant.orderDetails.application.usecase.CreatDetailsDto;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;

import java.util.List;
import java.util.UUID;

public interface CreatingDetailsInputPort {
    List<OrderDetailsDomainEntity> creatingDetails(List<CreatDetailsDto> creatDetailsDto, UUID orderId);
}

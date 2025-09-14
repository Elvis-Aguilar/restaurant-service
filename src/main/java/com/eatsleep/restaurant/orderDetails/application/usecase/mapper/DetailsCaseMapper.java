package com.eatsleep.restaurant.orderDetails.application.usecase.mapper;

import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.orderDetails.application.usecase.CreatDetailsDto;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DetailsCaseMapper {

    public OrderDetailsDomainEntity toDomainEntity(CreatDetailsDto  creatDetailsDto, UUID orderId, DishesDomainEntity  dishesDomainEntity) {
        return new OrderDetailsDomainEntity(orderId,
                dishesDomainEntity.getId(),
                creatDetailsDto.getQuantity(),
                dishesDomainEntity.getPrice(),
                dishesDomainEntity.getCost(),
                creatDetailsDto.getDiscountPercentage());
    }
}

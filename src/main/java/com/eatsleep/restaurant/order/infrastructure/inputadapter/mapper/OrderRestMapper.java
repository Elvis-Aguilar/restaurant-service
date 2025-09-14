package com.eatsleep.restaurant.order.infrastructure.inputadapter.mapper;

import com.eatsleep.restaurant.order.application.usecase.CreatOrderCaseDto;
import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.dto.DetailRequestDto;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.dto.DetailsResponseDto;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.dto.OrderRequestDto;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.dto.OrderResponseDto;
import com.eatsleep.restaurant.orderDetails.application.usecase.CreatDetailsDto;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRestMapper {


    public CreatOrderCaseDto toCreateOrderCaseDto(OrderRequestDto requestDto) {
        return new CreatOrderCaseDto(
                requestDto.getCustomerId(),
                requestDto.getRestaurantId(),
                requestDto.getDiscountPercentage(),
                toCreateDetailsDtoList(requestDto.getDetailRequestDtoList())
        );
    }

    private List<CreatDetailsDto> toCreateDetailsDtoList(List<DetailRequestDto> detailRequestDtoList) {
        if (detailRequestDtoList == null) {
            return List.of();
        }

        return detailRequestDtoList.stream()
                .map(this::toCreateDetailsDto)
                .collect(Collectors.toList());
    }

    private CreatDetailsDto toCreateDetailsDto(DetailRequestDto detailRequestDto) {
        return new CreatDetailsDto(
                detailRequestDto.getDishId(),
                detailRequestDto.getQuantity(),
                detailRequestDto.getDiscountPercentage()
        );
    }

    private DetailsResponseDto toResponseDto(OrderDetailsDomainEntity orderDetailsEntity) {
        return  DetailsResponseDto.builder()
                .id(orderDetailsEntity.getId())
                .quantity(orderDetailsEntity.getQuantity())
                .unitPrice(orderDetailsEntity.getUnitPrice())
                .discountPercentage(orderDetailsEntity.getDiscountPercentage())
                .unitCost(orderDetailsEntity.getUnitCost())
                .subtotal(orderDetailsEntity.getSubtotal())
                .promotionId(orderDetailsEntity.getPromotionId())
                .orderId(orderDetailsEntity.getOrderId())
                .dishId(orderDetailsEntity.getDishId())
                .dishName(orderDetailsEntity.getDishName())
                .build();
    }

    private List<DetailsResponseDto> toListResponse(List<OrderDetailsDomainEntity> orderDetailsEntityList) {
        return  orderDetailsEntityList
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public OrderResponseDto toOrderResponse(OrderDomainEntity orderDomainEntity){
        return OrderResponseDto.builder()
                .details(this.toListResponse(orderDomainEntity.getDetails()))
                .restaurantId(orderDomainEntity.getRestaurantId())
                .restaurantName(orderDomainEntity.getRestaurantName())
                .createdAt(orderDomainEntity.getCreatedAt())
                .customerId(orderDomainEntity.getCustomerId())
                .totalPrice(orderDomainEntity.getTotalPrice())
                .id(orderDomainEntity.getId())
                .discountPercentage(orderDomainEntity.getDiscountPercentage())
                .promotionId(orderDomainEntity.getPromotionId())
                .build();
    }

}

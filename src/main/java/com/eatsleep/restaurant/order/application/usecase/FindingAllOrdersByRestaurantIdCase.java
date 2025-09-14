package com.eatsleep.restaurant.order.application.usecase;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.order.application.factory.OrderFactory;
import com.eatsleep.restaurant.order.application.ports.input.FindingAllOrderByRestaurantIdInputPort;
import com.eatsleep.restaurant.order.application.ports.output.FindingAllOrderByRestaurantIdOutputPort;
import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;


@UseCase
@Validated
@RequiredArgsConstructor
public class FindingAllOrdersByRestaurantIdCase implements FindingAllOrderByRestaurantIdInputPort {

    private final FindingAllOrderByRestaurantIdOutputPort outputPort;
    private final OrderFactory orderFactory;

    @Override
    public List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId) {
        return outputPort.findAllOrderByRestaurantId(restaurantId)
                .stream()
                .map(orderFactory::createOrderWithDetails)
                .toList();
    }
}

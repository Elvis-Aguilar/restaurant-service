package com.eatsleep.restaurant.order.application.usecase;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.order.application.factory.OrderFactory;
import com.eatsleep.restaurant.order.application.ports.input.ReportOrderByRestaurantIdInputPort;
import com.eatsleep.restaurant.order.application.ports.output.ReportOrderByRestaurantIdAndRangeOutputPort;
import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@UseCase
@Validated
@RequiredArgsConstructor
public class ReportRangeByRetaurantIdCase implements ReportOrderByRestaurantIdInputPort {

    private final ReportOrderByRestaurantIdAndRangeOutputPort outputPort;
    private final OrderFactory orderFactory;

    @Override
    public List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId, RangeDateCaseDto range) {
        return outputPort.findAllOrderByRestaurantId(restaurantId, range.getStartDate(), range.getEndDate())
                .stream()
                .map(orderFactory::createOrderWithDetails)
                .toList();
    }
}

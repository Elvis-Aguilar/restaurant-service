package com.eatsleep.restaurant.order.application.factory;

import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import com.eatsleep.restaurant.orderDetails.application.ports.output.FindingAllDetailsByOrderIdOutputPort;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFactory {

    private final FindingAllDetailsByOrderIdOutputPort  findingAllDetailsByOrderIdOutputPort;

    public OrderDomainEntity createOrderWithDetails(OrderDomainEntity  order) {
        List<OrderDetailsDomainEntity> details = findingAllDetailsByOrderIdOutputPort.findAllByOrderId(order.getId());
        order.setDetails(details);
        return order;
    }
}

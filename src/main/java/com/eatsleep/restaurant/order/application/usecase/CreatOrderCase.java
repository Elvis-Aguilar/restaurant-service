package com.eatsleep.restaurant.order.application.usecase;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.order.application.ports.input.CreatingOrderInputPort;
import com.eatsleep.restaurant.order.application.ports.output.CreatingBillOutputPort;
import com.eatsleep.restaurant.order.application.ports.output.FindingCustomerByIdIOutputPort;
import com.eatsleep.restaurant.order.application.ports.output.StoringOrderOutputPort;
import com.eatsleep.restaurant.order.application.ports.output.UpdateTotalOrderOutputPort;
import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto.CreateBillRequestDto;
import com.eatsleep.restaurant.orderDetails.application.ports.input.CreatingDetailsInputPort;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import com.eatsleep.restaurant.restaurant.application.ports.output.FindingRestaurantByIdOutputPort;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@UseCase
@Validated
@RequiredArgsConstructor
public class CreatOrderCase implements CreatingOrderInputPort {

    private final CreatingDetailsInputPort creatingDetailsInputPort;
    private final FindingCustomerByIdIOutputPort findingCustomerByIdIOutputPort;
    private final FindingRestaurantByIdOutputPort findingRestaurantByIdOutputPort;
    private final StoringOrderOutputPort storingOrderOutputPort;
    private final UpdateTotalOrderOutputPort updateTotalOrderOutputPort;
    private final CreatingBillOutputPort creatingBillOutputPort;
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void creatingOrder(CreatOrderCaseDto creatOrderCaseDto) {
        // validar al cutomer
        UUID customerId = findingCustomerByIdIOutputPort
                .getCustomerById(creatOrderCaseDto.getCustomerId())
                .getId();

        // validar restaurant
        UUID restauranId = findingRestaurantByIdOutputPort
                .findingRestaurantById(creatOrderCaseDto.getRestaurantId())
                .getId();

        // guardar orden
        OrderDomainEntity newOrder = new OrderDomainEntity(BigDecimal.ZERO,creatOrderCaseDto.getDiscountPercentage(),
                null, restauranId, customerId);
        OrderDomainEntity savedOrder = storingOrderOutputPort.saveOrder(newOrder);

        entityManager.flush();

        // guardar detalles
        List<OrderDetailsDomainEntity> details = creatingDetailsInputPort.creatingDetails(creatOrderCaseDto.getDetails(), savedOrder.getId());

        savedOrder.setDetails(details);

        // actualizar orden (totales)
        BigDecimal total = savedOrder.calculationTotalPrice();
        updateTotalOrderOutputPort.updateTotalOrder(savedOrder.getId(), total);

        // registrar pago finance
        CreateBillRequestDto createBillRequestDto = new CreateBillRequestDto(savedOrder.getId(), "order", total);

        creatingBillOutputPort.createBill(createBillRequestDto);
    }
}

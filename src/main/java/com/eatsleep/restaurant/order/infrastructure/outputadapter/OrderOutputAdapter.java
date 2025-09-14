package com.eatsleep.restaurant.order.infrastructure.outputadapter;

import com.eatsleep.restaurant.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.restaurant.common.infrastructure.exception.BadRequestException;
import com.eatsleep.restaurant.order.application.ports.output.FindingAllOrderByRestaurantIdOutputPort;
import com.eatsleep.restaurant.order.application.ports.output.StoringOrderOutputPort;
import com.eatsleep.restaurant.order.application.ports.output.UpdateTotalOrderOutputPort;
import com.eatsleep.restaurant.order.domain.model.OrderDomainEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity.OrderDBEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.mapper.OrderPersistenceMapper;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.repository.OrderDBRepository;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity.RestaurantDBEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.repository.RestaurantDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class OrderOutputAdapter implements StoringOrderOutputPort, UpdateTotalOrderOutputPort,
        FindingAllOrderByRestaurantIdOutputPort {

    private final OrderDBRepository orderDBRepository;
    private final OrderPersistenceMapper mapper;
    private final RestaurantDBRepository rdbRepository;

    @Override
    @Transactional
    public OrderDomainEntity saveOrder(OrderDomainEntity orderDomainEntity) {
        RestaurantDBEntity restaurantDBEntity = rdbRepository.findById(orderDomainEntity.getRestaurantId())
                .orElseThrow(() -> new BadRequestException("Restaurante no encontrado"));
        OrderDBEntity newOrderDBEntity = mapper.toOrderDBEntity(orderDomainEntity, restaurantDBEntity);
        OrderDBEntity savedEntity = orderDBRepository.save(newOrderDBEntity);
        return mapper.toOrderDomainEntity(savedEntity);
    }

    @Override
    @Transactional
    public void updateTotalOrder(UUID orderId, BigDecimal totalPrice) {
        OrderDBEntity orderDBEntity =  orderDBRepository.findById(orderId)
                .orElseThrow(()-> new BadRequestException("Orden No encontrada para Actualizar"));
        orderDBEntity.setTotalPrice(totalPrice);
        orderDBRepository.save(orderDBEntity);
    }

    @Override
    public List<OrderDomainEntity> findAllOrderByRestaurantId(UUID restaurantId) {
        return orderDBRepository.findAllByRestaurantId(restaurantId)
                .stream()
                .map(mapper::toOrderDomainEntity)
                .toList();
    }
}

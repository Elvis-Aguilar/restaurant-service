package com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter;

import com.eatsleep.restaurant.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.restaurant.orderDetails.application.ports.output.FindingAllDetailsByOrderIdOutputPort;
import com.eatsleep.restaurant.orderDetails.application.ports.output.StoringAllDetailsOutputPort;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.entity.OrderDetailsDBEntity;
import com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.mapper.DetailsPersistenceMapper;
import com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.repository.OrderDetailsDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class OrderDetailsOutputAdapter implements StoringAllDetailsOutputPort,
        FindingAllDetailsByOrderIdOutputPort {

    private final OrderDetailsDBRepository orderDetailsDBRepository;
    private final DetailsPersistenceMapper mapper;


    @Override
    @Transactional
    public void storingAllDetails(List<OrderDetailsDomainEntity> orderDetails) {
        List<OrderDetailsDBEntity> entities = orderDetails.stream()
                .map(mapper::toDBEntity)
                .toList();
        orderDetailsDBRepository.saveAll(entities);
    }

    @Override
    public List<OrderDetailsDomainEntity> findAllByOrderId(UUID orderId) {
        return orderDetailsDBRepository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

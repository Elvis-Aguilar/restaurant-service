package com.eatsleep.restaurant.order.infrastructure.outputadapter.client;

import com.eatsleep.restaurant.common.infrastructure.exception.ExternalServiceException;
import com.eatsleep.restaurant.order.application.ports.output.CreatingBillOutputPort;
import com.eatsleep.restaurant.order.application.ports.output.FindingCustomerByIdIOutputPort;
import com.eatsleep.restaurant.order.domain.model.CustomerDomainEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto.CreateBillRequestDto;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto.CustomerResponseDto;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.rest.BillRestClient;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.rest.CustomerRestClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientOutputAdapter implements FindingCustomerByIdIOutputPort,
        CreatingBillOutputPort {

    private final CustomerRestClient customerRestClient;
    private final BillRestClient billRestClient;

    @Override
    public CustomerDomainEntity getCustomerById(UUID customerId) {
        try {
            CustomerResponseDto dto = customerRestClient.getCustomerById(customerId);
            return new CustomerDomainEntity(dto.id(), dto.fullName());
        }catch (FeignException ex){
            throw new ExternalServiceException("No se pudo encontrar al cliente para la orden.");
        }
    }

    @Override
    public void createBill(CreateBillRequestDto createBillRequestDto) {
        try {
            billRestClient.createBill(createBillRequestDto);
        }catch (FeignException ex){
            ex.printStackTrace();
            throw new ExternalServiceException("No se pudo crear la factura.");
        }
    }
}

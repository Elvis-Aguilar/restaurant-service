package com.eatsleep.restaurant.order.application.ports.output;

import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto.CreateBillRequestDto;

public interface CreatingBillOutputPort {
    void createBill(CreateBillRequestDto createBillRequestDto);
}

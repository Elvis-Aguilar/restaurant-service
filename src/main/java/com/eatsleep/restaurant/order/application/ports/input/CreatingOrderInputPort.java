package com.eatsleep.restaurant.order.application.ports.input;

import com.eatsleep.restaurant.order.application.usecase.CreatOrderCaseDto;

public interface CreatingOrderInputPort {
    void creatingOrder(CreatOrderCaseDto creatOrderCaseDto);
}

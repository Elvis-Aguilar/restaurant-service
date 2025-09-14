package com.eatsleep.restaurant.order.infrastructure.outputadapter.client.rest;

import com.eatsleep.restaurant.order.infrastructure.outputadapter.client.dto.CreateBillRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "finance", url = "${client.services.finance}/api/finance")
public interface BillRestClient {

    @PostMapping("/v1/bills")
    void createBill(@RequestBody CreateBillRequestDto requestDto);
}

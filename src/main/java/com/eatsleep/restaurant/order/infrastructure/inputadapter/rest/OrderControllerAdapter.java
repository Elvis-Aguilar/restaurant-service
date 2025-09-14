package com.eatsleep.restaurant.order.infrastructure.inputadapter.rest;

import com.eatsleep.restaurant.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.restaurant.order.application.ports.input.CreatingOrderInputPort;
import com.eatsleep.restaurant.order.application.ports.input.FindingAllOrderByRestaurantIdInputPort;
import com.eatsleep.restaurant.order.application.usecase.CreatOrderCaseDto;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.dto.OrderRequestDto;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.dto.OrderResponseDto;
import com.eatsleep.restaurant.order.infrastructure.inputadapter.mapper.OrderRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/orders")
@WebAdapter
@RequiredArgsConstructor
public class OrderControllerAdapter {

    private final CreatingOrderInputPort creatingOrderInputPort;
    private final OrderRestMapper mapper;
    private final FindingAllOrderByRestaurantIdInputPort findingAllOrderByRestaurantIdInputPort;

    @PostMapping("")
    public ResponseEntity<Void> createOrder(@RequestBody @Valid OrderRequestDto  orderRequestDto) {
        CreatOrderCaseDto caseDto = mapper.toCreateOrderCaseDto(orderRequestDto);
        creatingOrderInputPort.creatingOrder(caseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<List<OrderResponseDto>>  findAllOrderByRestaurantId(@PathVariable UUID restaurantId) {
        List<OrderResponseDto> dtoList = findingAllOrderByRestaurantIdInputPort.findAllOrderByRestaurantId(restaurantId)
                .stream()
                .map(mapper::toOrderResponse)
                .toList();

        return ResponseEntity.ok(dtoList);

    }
}

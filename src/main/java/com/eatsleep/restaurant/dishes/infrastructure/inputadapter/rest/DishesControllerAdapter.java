package com.eatsleep.restaurant.dishes.infrastructure.inputadapter.rest;

import com.eatsleep.restaurant.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.restaurant.dishes.application.ports.input.FindingDishesByIdInputPort;
import com.eatsleep.restaurant.dishes.application.ports.input.ListAllDishesByRestaurantIdtInputPort;
import com.eatsleep.restaurant.dishes.infrastructure.inputadapter.dto.DishesResponseDto;
import com.eatsleep.restaurant.dishes.infrastructure.inputadapter.mapper.DishesRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/dishes")
@WebAdapter
@RequiredArgsConstructor
public class DishesControllerAdapter {

    private final DishesRestMapper mapper;
    private final FindingDishesByIdInputPort findingDishesByIdInputPort;
    private final ListAllDishesByRestaurantIdtInputPort listAllDishesByRestaurantIdtInputPort;


    @GetMapping("/{id}")
    public ResponseEntity<DishesResponseDto> findingDishesById(@PathVariable UUID id) {
        DishesResponseDto dto = mapper.toResponseDto(findingDishesByIdInputPort.findingDishesById(id));

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<DishesResponseDto>> findAllDishesByRestaurantId(@PathVariable UUID id) {
        List<DishesResponseDto> list = listAllDishesByRestaurantIdtInputPort.findAllDishesByRestaurantId(id)
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(list);
    }
}

package com.eatsleep.restaurant.restaurant.infrastructure.inputadapter.rest;

import com.eatsleep.restaurant.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.restaurant.restaurant.application.ports.input.FindingRestaurantByIdInputPort;
import com.eatsleep.restaurant.restaurant.application.ports.input.ListAllRestaurantInputPort;
import com.eatsleep.restaurant.restaurant.infrastructure.inputadapter.dto.RestaurantResponseDto;
import com.eatsleep.restaurant.restaurant.infrastructure.inputadapter.mapper.RestaurantRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/restaurants")
@WebAdapter
@RequiredArgsConstructor
public class RestaurantControllerAdapter {

    private final RestaurantRestMapper restaurantRestMapper;
    private final ListAllRestaurantInputPort listAllRestaurantInputPort;
    private final FindingRestaurantByIdInputPort findingRestaurantByIdInputPort;


    @GetMapping()
    public ResponseEntity<List<RestaurantResponseDto>> listAllRestaurants() {
        List<RestaurantResponseDto> list = this.listAllRestaurantInputPort.listAllRestaurants()
                .stream()
                .map(restaurantRestMapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> findById(@PathVariable UUID id) {
        RestaurantResponseDto dto = restaurantRestMapper.toResponseDto(findingRestaurantByIdInputPort.findingRestaurantById(id));

        return ResponseEntity.ok(dto);
    }
}

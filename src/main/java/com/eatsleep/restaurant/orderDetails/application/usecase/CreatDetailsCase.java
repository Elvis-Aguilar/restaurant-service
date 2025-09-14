package com.eatsleep.restaurant.orderDetails.application.usecase;

import com.eatsleep.restaurant.common.application.annotations.UseCase;
import com.eatsleep.restaurant.dishes.application.ports.output.ValidDishesIdOutputPort;
import com.eatsleep.restaurant.dishes.domain.DishesDomainEntity;
import com.eatsleep.restaurant.orderDetails.application.ports.input.CreatingDetailsInputPort;
import com.eatsleep.restaurant.orderDetails.application.ports.output.StoringAllDetailsOutputPort;
import com.eatsleep.restaurant.orderDetails.application.usecase.mapper.DetailsCaseMapper;
import com.eatsleep.restaurant.orderDetails.domain.model.OrderDetailsDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@UseCase
@Validated
@RequiredArgsConstructor
public class CreatDetailsCase implements CreatingDetailsInputPort {

    private final StoringAllDetailsOutputPort output;
    private final ValidDishesIdOutputPort validDishesIdOutputPort;
    private final DetailsCaseMapper mapper;

    @Override
    public List<OrderDetailsDomainEntity> creatingDetails(List<CreatDetailsDto> creatDetailsDto, UUID orderId) {
        List<UUID> uuids = creatDetailsDto.stream()
                .map(CreatDetailsDto::getDishId)
                .toList();

        // validar dishes y obtener sus datos
        List<DishesDomainEntity> dishes = validDishesIdOutputPort.validDishesId(uuids);

        // crear details
        Map<UUID, DishesDomainEntity> dishesMap = dishes.stream()
                .collect(Collectors.toMap(DishesDomainEntity::getId, Function.identity()));

        // usar el mapper para crear los detalles
        List<OrderDetailsDomainEntity> details = creatDetailsDto.stream()
                .map(dto -> {
                    DishesDomainEntity dish = dishesMap.get(dto.getDishId());
                    return mapper.toDomainEntity(dto, orderId, dish);
                })
                .toList();


        // cuardar details
        output.storingAllDetails(details);

        return details;
    }
}

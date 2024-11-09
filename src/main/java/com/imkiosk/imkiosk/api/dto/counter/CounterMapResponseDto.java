package com.imkiosk.imkiosk.api.dto.counter;

import com.imkiosk.imkiosk.api.entity.counter.CounterMap;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CounterMapResponseDto {
    private Long wdMapId;
    private Byte layer;
    private Byte width;
    private Byte height;
    private List<CounterMapItemResponseDto> counterMapItems;

    public static CounterMapResponseDto toDto(CounterMap counterMap) {
        List<CounterMapItemResponseDto> counterMapItemResponseDtos = counterMap.getCounterMapItems().stream()
                .map(CounterMapItemResponseDto::toDto)
                .collect(Collectors.toList());

        return CounterMapResponseDto.builder()
                .wdMapId(counterMap.getWdMapId())
                .layer(counterMap.getLayer())
                .width(counterMap.getWidth())
                .height(counterMap.getHeight())
                .counterMapItems(counterMapItemResponseDtos)
                .build();
    }
}
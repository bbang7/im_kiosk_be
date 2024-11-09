package com.imkiosk.imkiosk.api.dto.counter;


import com.imkiosk.imkiosk.api.entity.counter.CounterMapItem;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounterMapItemResponseDto {
    private Long wdMapId;
    private Long wdMapItemId;
    private Long wdId;
    private String name;
    private String color;
    private Byte x;
    private Byte y;

    public static CounterMapItemResponseDto toDto(CounterMapItem counterMapItem) {
        return CounterMapItemResponseDto.builder()
                .wdMapId(counterMapItem.getCounterMap().getWdMapId())
                .wdMapItemId(counterMapItem.getWdMapItemId())
                .wdId(counterMapItem.getWdId())
                .name(counterMapItem.getName())
                .color(counterMapItem.getColor())
                .x(counterMapItem.getX())
                .y(counterMapItem.getY())
                .build();
    }
}


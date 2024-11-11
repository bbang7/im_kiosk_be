package com.imkiosk.imkiosk.api.dto.counter;

import lombok.Data;

import java.util.List;

@Data
public class CounterMapUpdateDto {
    private Long wdMapId;
    private Byte width;
    private Byte height;
    private List<CounterMapItemUpdateDto> counterMapItemUpdateDtos;
}

package com.imkiosk.imkiosk.api.dto.counter;

import lombok.Data;

import java.util.List;

@Data
public class CounterMapUpdateDto {
    private Long wdMapId; // CounterMap ID
    private Byte width;   // 새로운 너비
    private Byte height;  // 새로운 높이
    private List<CounterMapItemUpdateDto> counterMapItemUpdateDtos;
}

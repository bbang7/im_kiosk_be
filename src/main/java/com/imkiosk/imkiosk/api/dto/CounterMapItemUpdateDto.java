package com.imkiosk.imkiosk.api.dto;

import lombok.Data;

@Data
public  class CounterMapItemUpdateDto {
    private Long wdMapItemId; // CounterMapItem ID
    private Long wdId;        // 관련 ID
    private String name;      // 카운터 이름
    private String color;     // 카운터 색상
    private Byte x;           // x 좌표
    private Byte y;           // y 좌표
}

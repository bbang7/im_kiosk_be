package com.imkiosk.imkiosk.api.dto.counter;

import lombok.Data;

@Data
public  class CounterMapItemUpdateDto {
    private Long wdMapItemId;
    private Long wdId;
    private String name;
    private String color;
    private Byte x;
    private Byte y;
}

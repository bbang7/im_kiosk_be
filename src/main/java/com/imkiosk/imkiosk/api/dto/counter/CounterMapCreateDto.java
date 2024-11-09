package com.imkiosk.imkiosk.api.dto.counter;

import lombok.*;

@Data
public class CounterMapCreateDto {
    private Long deptId;
    private Byte layer;
    private Byte width;
    private Byte height;
}

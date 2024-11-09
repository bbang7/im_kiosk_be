package com.imkiosk.imkiosk.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounterCreateDto {
    private Long deptId;
    private String wdName;
    private Integer wdCount;
}
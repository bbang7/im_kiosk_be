package com.imkiosk.imkiosk.api.dto.counter;


import com.imkiosk.imkiosk.api.entity.counter.Counter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CounterDto {
    private Long wdId;
    private String wdName;
    private Integer wdCount;
    private String color;

    public static CounterDto toDto(Counter counter) {
        return CounterDto.builder()
                .wdId(counter.getWdId())
                .wdName(counter.getWdName())
                .wdCount(counter.getWdCount())
                .color(counter.getColor())
                .build();
    }
}

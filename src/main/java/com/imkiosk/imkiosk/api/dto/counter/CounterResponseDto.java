package com.imkiosk.imkiosk.api.dto.counter;


import com.imkiosk.imkiosk.api.entity.counter.Counter;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounterResponseDto {
    private Long deptId;
    private String deptName;
    private List<CounterDto> counters;

    public static CounterResponseDto toDto(List<Counter> counters) {
        if (counters.isEmpty()) {
            return null; // 또는 빈 DTO 반환
        }

        Counter firstCounter = counters.get(0); // 첫 번째 Counter의 정보를 사용

        return CounterResponseDto.builder()
                .deptId(firstCounter.getBranch() != null ? firstCounter.getBranch().getDeptId() : null)
                .deptName(firstCounter.getBranch() != null ? firstCounter.getBranch().getDeptName() : null)
                .counters(counters.stream()
                        .map(CounterDto::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

}

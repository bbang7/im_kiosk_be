package com.imkiosk.imkiosk.api.dto.branch;


import com.imkiosk.imkiosk.api.dto.counter.CounterMapResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchCounterMapResponseDto {
    private Long deptId;
    private List<CounterMapResponseDto> counterMaps;

    public static BranchCounterMapResponseDto toDto(Long deptId, List<CounterMapResponseDto> counterMaps) {
        return BranchCounterMapResponseDto.builder()
                .deptId(deptId)
                .counterMaps(counterMaps != null ? counterMaps : List.of())
                .build();
    }
}

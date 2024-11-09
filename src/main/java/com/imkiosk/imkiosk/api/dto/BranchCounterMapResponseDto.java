package com.imkiosk.imkiosk.api.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchCounterMapResponseDto {
    private Long deptId; // 부서 ID
    private List<CounterMapResponseDto> counterMaps; // 카운터 맵 목록

    public static BranchCounterMapResponseDto toDto(Long deptId, List<CounterMapResponseDto> counterMaps) {
        return BranchCounterMapResponseDto.builder()
                .deptId(deptId)
                .counterMaps(counterMaps != null ? counterMaps : List.of())
                .build();
    }
}

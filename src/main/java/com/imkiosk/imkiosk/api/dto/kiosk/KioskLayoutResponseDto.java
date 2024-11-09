package com.imkiosk.imkiosk.api.dto.kiosk;


import com.imkiosk.imkiosk.api.entity.kiosk.KioskLayout;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KioskLayoutResponseDto {
    private Long deptId;
    private String deptName;
    private List<KioskLayoutDto> kioskLayouts;

    public static KioskLayoutResponseDto toDto(List<KioskLayout> kioskLayouts){
        if(kioskLayouts.isEmpty()){
            return null;
        }

        KioskLayout firstKioskLayout = kioskLayouts.get(0);

        return KioskLayoutResponseDto.builder()
                .deptId(firstKioskLayout.getBranch() != null ? firstKioskLayout.getBranch().getDeptId() : null)
                .deptName(firstKioskLayout.getBranch() != null ? firstKioskLayout.getBranch().getDeptName() : null)
                .kioskLayouts(kioskLayouts.stream()
                            .map(KioskLayoutDto::toDto)
                            .collect(Collectors.toList()))
                .build();

    }

}

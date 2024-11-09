package com.imkiosk.imkiosk.api.dto.kiosk;

import com.imkiosk.imkiosk.api.entity.kiosk.KioskLayout;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KioskLayoutDto {
    private Long kioskLayoutId;
    private Byte buttonIndex;
    private Boolean isCommon;
    private Byte commonItemId;
    private Byte wdId;
    private String name;
    private Boolean isPlaced;

    public static KioskLayoutDto toDto(KioskLayout kioskLayout){
        return KioskLayoutDto.builder()
                .kioskLayoutId(kioskLayout.getKioskLayoutId())
                .buttonIndex(kioskLayout.getButtonIndex())
                .isCommon(kioskLayout.getIsCommon())
                .commonItemId(kioskLayout.getCommonItemId())
                .wdId(kioskLayout.getWdId())
                .name(kioskLayout.getName())
                .isPlaced(kioskLayout.getIsPlaced())
                .build();
    }
}

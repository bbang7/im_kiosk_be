package com.imkiosk.imkiosk.api.dto.kiosk;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KioskLayoutRequestDto {
    private Long deptId;
    private List<KioskLayoutDto> kioskLayouts;

}

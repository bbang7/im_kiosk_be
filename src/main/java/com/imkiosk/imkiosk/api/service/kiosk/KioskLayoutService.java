package com.imkiosk.imkiosk.api.service.kiosk;


import com.imkiosk.imkiosk.api.dto.kiosk.KioskLayoutRequestDto;
import com.imkiosk.imkiosk.api.dto.kiosk.KioskLayoutResponseDto;

public interface KioskLayoutService {
    KioskLayoutResponseDto getKioskLayouts(Long deptId);
    void updateKioskLayouts(KioskLayoutRequestDto kioskLayoutRequestDto);
}

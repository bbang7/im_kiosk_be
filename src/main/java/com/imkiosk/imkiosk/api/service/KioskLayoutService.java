package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.KioskLayoutRequestDto;
import com.imkiosk.imkiosk.api.dto.KioskLayoutResponseDto;

public interface KioskLayoutService {
    KioskLayoutResponseDto getKioskLayouts(Long deptId);
    void updateKioskLayouts(KioskLayoutRequestDto kioskLayoutRequestDto);
}

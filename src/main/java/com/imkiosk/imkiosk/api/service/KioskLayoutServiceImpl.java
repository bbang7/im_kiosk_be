package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.KioskLayoutDto;
import com.imkiosk.imkiosk.api.dto.KioskLayoutRequestDto;
import com.imkiosk.imkiosk.api.dto.KioskLayoutResponseDto;
import com.imkiosk.imkiosk.api.entity.KioskLayout;
import com.imkiosk.imkiosk.api.repository.KioskLayoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KioskLayoutServiceImpl implements KioskLayoutService {

    private final KioskLayoutRepository kioskLayoutRepository;

    @Override
    @Transactional
    public KioskLayoutResponseDto getKioskLayouts(Long deptId) {
        List<KioskLayout> kioskLayouts = kioskLayoutRepository.findByBranch_DeptId(deptId);
        return KioskLayoutResponseDto.toDto(kioskLayouts);
    }

    @Override
    @Transactional
    public void updateKioskLayouts(KioskLayoutRequestDto kioskLayoutRequestDto) {
        List<KioskLayoutDto> kioskLayouts = kioskLayoutRequestDto.getKioskLayouts();
        for(KioskLayoutDto kioskLayoutDto :kioskLayouts){
            KioskLayout kioskLayout = kioskLayoutRepository.findById(kioskLayoutDto.getKioskLayoutId())
                    .orElseThrow(() -> new RuntimeException("KioskLayout not found: " + kioskLayoutDto.getKioskLayoutId()));

            kioskLayout.setButtonIndex(kioskLayoutDto.getButtonIndex());
            kioskLayout.setIsPlaced(kioskLayoutDto.getIsPlaced());

            kioskLayoutRepository.save(kioskLayout);
        }
    }
}

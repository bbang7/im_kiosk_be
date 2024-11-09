package com.imkiosk.imkiosk.api.controller;


import com.imkiosk.imkiosk.api.dto.KioskLayoutRequestDto;
import com.imkiosk.imkiosk.api.dto.KioskLayoutResponseDto;
import com.imkiosk.imkiosk.api.service.KioskLayoutServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KioskLayoutController {

    @Autowired
    KioskLayoutServiceImpl kioskLayoutServiceImpl;

    @GetMapping("/kiosk-layout/{deptId}")
    public BaseResponse<KioskLayoutResponseDto> getKioskLayouts(@PathVariable(name = "deptId" ) Long deptId){
        return new BaseResponse<>(kioskLayoutServiceImpl.getKioskLayouts((deptId)));
    }

    @PutMapping("/kiosk-layout")
    public BaseResponse<Void> updateKioskLayouts(@RequestBody KioskLayoutRequestDto kioskLayoutRequestDto){
        kioskLayoutServiceImpl.updateKioskLayouts(kioskLayoutRequestDto);
        return new BaseResponse<>();
    }


}

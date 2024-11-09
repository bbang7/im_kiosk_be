package com.imkiosk.imkiosk.api.controller.kiosk;


import com.imkiosk.imkiosk.api.dto.kiosk.KioskLayoutRequestDto;
import com.imkiosk.imkiosk.api.dto.kiosk.KioskLayoutResponseDto;
import com.imkiosk.imkiosk.api.service.kiosk.KioskLayoutServiceImpl;
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

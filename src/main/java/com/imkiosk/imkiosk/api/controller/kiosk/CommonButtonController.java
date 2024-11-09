package com.imkiosk.imkiosk.api.controller.kiosk;


import com.imkiosk.imkiosk.api.dto.kiosk.CommonButtonDto;
import com.imkiosk.imkiosk.api.service.kiosk.CommonButtonServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonButtonController {
    @Autowired
    CommonButtonServiceImpl commonButtonServiceImpl;

    @PostMapping("/common-button")
    public BaseResponse<Void> createCommonButton(@RequestBody CommonButtonDto commonButtonDto){
        commonButtonServiceImpl.createCommonButton(commonButtonDto);
        return new BaseResponse<>();
    }

}

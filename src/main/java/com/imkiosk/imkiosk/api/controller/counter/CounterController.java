package com.imkiosk.imkiosk.api.controller.counter;


import com.imkiosk.imkiosk.api.dto.counter.CounterCreateDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterResponseDto;
import com.imkiosk.imkiosk.api.service.counter.CounterServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CounterController {

    @Autowired
    CounterServiceImpl counterServiceImpl;

    @GetMapping("/counter/{deptId}")
    public BaseResponse<CounterResponseDto> getCounters(@PathVariable("deptId") Long deptId){
        return new BaseResponse<>(counterServiceImpl.getCounters(deptId));
    }

    @PostMapping("/counter")
    public BaseResponse<CounterResponseDto> createCounter(@RequestBody CounterCreateDto counterCreateDto) {
        return new BaseResponse<>(counterServiceImpl.createCounter(counterCreateDto));
    }

}

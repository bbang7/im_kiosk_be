package com.imkiosk.imkiosk.api.controller;


import com.imkiosk.imkiosk.api.dto.BranchCounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.CounterMapCreateDto;
import com.imkiosk.imkiosk.api.dto.CounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.CounterMapUpdateDto;
import com.imkiosk.imkiosk.api.entity.CounterMap;
import com.imkiosk.imkiosk.api.service.CounterMapService;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CounterMapController {
    @Autowired
    CounterMapService counterMapService;

    @GetMapping("/counter-map/{deptId}")
    public BaseResponse<BranchCounterMapResponseDto> getCounterMaps(@PathVariable(name = "deptId") Long deptId) {
        BranchCounterMapResponseDto branchCounterMapResponseDto = counterMapService.getCounterMapsByDeptId(deptId);
        return new BaseResponse<>(branchCounterMapResponseDto);
    }

    @PostMapping("/counter-map")
    public BaseResponse<CounterMapResponseDto> createCounterMap(
                                                                @RequestBody CounterMapCreateDto counterMapCreateDto) {
        CounterMapResponseDto counterMapResponseDto = counterMapService.createCounterMap(counterMapCreateDto);
        return new BaseResponse<>(counterMapResponseDto);
    }

    @PutMapping("/counter-map")
    public BaseResponse<CounterMapResponseDto> updateCounterMap(@RequestBody CounterMapUpdateDto counterMapUpdateDto) {
        CounterMap counterMap = counterMapService.updateCounterMap(counterMapUpdateDto);
        return new BaseResponse<>(CounterMapResponseDto.toDto(counterMap));
    }

    @DeleteMapping("/counter-map/{wdMapId}")
    public BaseResponse<Void> deleteCounterMap(@PathVariable(name = "wdMapId") Long wdMapId) {
        counterMapService.deleteCounterMap(wdMapId);
        return new BaseResponse<>();
    }
}

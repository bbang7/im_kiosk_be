package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.BranchCounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.CounterMapCreateDto;
import com.imkiosk.imkiosk.api.dto.CounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.CounterMapUpdateDto;
import com.imkiosk.imkiosk.api.entity.CounterMap;

public interface CounterMapService {
    BranchCounterMapResponseDto getCounterMapsByDeptId(Long deptId);
    CounterMapResponseDto createCounterMap(CounterMapCreateDto counterMapCreateDto);
    CounterMap updateCounterMap(CounterMapUpdateDto counterMapUpdateDto);
    void deleteCounterMap(Long wdMapId);
}

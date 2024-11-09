package com.imkiosk.imkiosk.api.service.counter;


import com.imkiosk.imkiosk.api.dto.branch.BranchCounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapCreateDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapUpdateDto;
import com.imkiosk.imkiosk.api.entity.counter.CounterMap;

public interface CounterMapService {
    BranchCounterMapResponseDto getCounterMapsByDeptId(Long deptId);
    CounterMapResponseDto createCounterMap(CounterMapCreateDto counterMapCreateDto);
    CounterMap updateCounterMap(CounterMapUpdateDto counterMapUpdateDto);
    void deleteCounterMap(Long wdMapId);
}

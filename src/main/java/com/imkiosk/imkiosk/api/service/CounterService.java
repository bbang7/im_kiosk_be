package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.CounterCreateDto;
import com.imkiosk.imkiosk.api.dto.CounterResponseDto;

public interface CounterService {
    CounterResponseDto getCounters(Long deptId);
    CounterResponseDto createCounter(CounterCreateDto counterCreateDto);
}

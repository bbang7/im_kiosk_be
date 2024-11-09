package com.imkiosk.imkiosk.api.service.counter;


import com.imkiosk.imkiosk.api.dto.counter.CounterCreateDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterResponseDto;

public interface CounterService {
    CounterResponseDto getCounters(Long deptId);
    CounterResponseDto createCounter(CounterCreateDto counterCreateDto);
}

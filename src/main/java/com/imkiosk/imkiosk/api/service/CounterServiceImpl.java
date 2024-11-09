package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.CounterCreateDto;
import com.imkiosk.imkiosk.api.dto.CounterResponseDto;
import com.imkiosk.imkiosk.api.entity.Branch;
import com.imkiosk.imkiosk.api.entity.Counter;
import com.imkiosk.imkiosk.api.entity.KioskLayout;
import com.imkiosk.imkiosk.api.repository.BranchRepository;
import com.imkiosk.imkiosk.api.repository.CounterRepository;
import com.imkiosk.imkiosk.api.repository.KioskLayoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;
    private final BranchRepository branchRepository;
    private final KioskLayoutRepository kioskLayoutRepository;

    @Override
    @Transactional
    public CounterResponseDto getCounters(Long deptId) {
        List<Counter> counters = counterRepository.findByBranch_DeptId(deptId);
        return CounterResponseDto.toDto(counters);
    }

    @Override
    @Transactional
    public CounterResponseDto createCounter(CounterCreateDto counterCreateDto) {
        // 부서 ID로 Branch 객체를 찾습니다.
        Branch branch = branchRepository.findById(counterCreateDto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Branch not found")); // 예외 처리

//        if (counterRepository.findByWdName(counterCreateDto.getWdName()).isPresent()) {
//            throw new RuntimeException("Counter with the same wdName already exists"); // 중복 예외 처리
//        }
        if (counterRepository.findByWdNameAndBranchDeptId(counterCreateDto.getWdName(), counterCreateDto.getDeptId()).isPresent()) {
            throw new RuntimeException("Counter with the same wdName already exists in this department"); // 중복 예외 처리
        }

        // Counter 객체 생성
        Counter counter = new Counter();
        counter.setBranch(branch);
        counter.setWdName(counterCreateDto.getWdName());
        counter.setWdCount(counterCreateDto.getWdCount());

        // Counter 저장
        counterRepository.save(counter);

        // 초기 인덱스를 설정해줘야할까?
        KioskLayout kioskLayout = new KioskLayout();
        kioskLayout.setBranch(counter.getBranch());
        kioskLayout.setWdId((byte) counter.getWdId().intValue());
        kioskLayout.setIsCommon(false);
        kioskLayout.setName(counter.getWdName());
        kioskLayout.setIsPlaced(false);

        kioskLayoutRepository.save(kioskLayout);

        // 저장된 Counter를 기반으로 CounterResponseDto 생성
        return CounterResponseDto.toDto(Collections.singletonList(counter));
    }

}

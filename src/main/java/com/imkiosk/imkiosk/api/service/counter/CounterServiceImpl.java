package com.imkiosk.imkiosk.api.service.counter;


import com.imkiosk.imkiosk.api.dto.counter.CounterCreateDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterResponseDto;
import com.imkiosk.imkiosk.api.entity.branch.Branch;
import com.imkiosk.imkiosk.api.entity.counter.Counter;
import com.imkiosk.imkiosk.api.entity.kiosk.KioskLayout;
import com.imkiosk.imkiosk.api.repository.branch.BranchRepository;
import com.imkiosk.imkiosk.api.repository.counter.CounterRepository;
import com.imkiosk.imkiosk.api.repository.kiosk.KioskLayoutRepository;
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
        Branch branch = branchRepository.findById(counterCreateDto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        if (counterRepository.findByWdNameAndBranchDeptId(counterCreateDto.getWdName(), counterCreateDto.getDeptId()).isPresent()) {
            throw new RuntimeException("Counter with the same wdName already exists in this department"); // 중복 예외 처리
        }

        Counter counter = new Counter();
        counter.setBranch(branch);
        counter.setWdName(counterCreateDto.getWdName());
        counter.setWdCount(counterCreateDto.getWdCount());

        counterRepository.save(counter);

        // 초기 인덱스를 설정해줘야할까?
        KioskLayout kioskLayout = new KioskLayout();
        kioskLayout.setBranch(counter.getBranch());
        kioskLayout.setWdId((byte) counter.getWdId().intValue());
        kioskLayout.setIsCommon(false);
        kioskLayout.setName(counter.getWdName());
        kioskLayout.setIsPlaced(false);

        kioskLayoutRepository.save(kioskLayout);

        return CounterResponseDto.toDto(Collections.singletonList(counter));
    }

}

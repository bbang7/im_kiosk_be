package com.imkiosk.imkiosk.api.service;

import com.imkiosk.imkiosk.api.dto.*;
import com.imkiosk.imkiosk.api.entity.Branch;
import com.imkiosk.imkiosk.api.entity.CounterMap;
import com.imkiosk.imkiosk.api.entity.CounterMapItem;
import com.imkiosk.imkiosk.api.repository.BranchRepository;
import com.imkiosk.imkiosk.api.repository.CounterMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterMapServiceImpl implements CounterMapService {

    private final CounterMapRepository counterMapRepository;
    private final BranchRepository branchRepository;

    @Override
    @Transactional
    public BranchCounterMapResponseDto getCounterMapsByDeptId(Long deptId) {
        List<CounterMap> counterMaps = counterMapRepository.findByBranchDeptId(deptId);

        List<CounterMapResponseDto> counterMapResponseDtos = counterMaps.stream()
                .map(CounterMapResponseDto::toDto) // CounterMap을 DTO로 변환
                .collect(Collectors.toList());

        return BranchCounterMapResponseDto.toDto(deptId, counterMapResponseDtos);
    }

    @Override
    @Transactional
    public CounterMapResponseDto createCounterMap(CounterMapCreateDto counterMapCreateDto) {
        // 부서 ID로 Branch 조회
        Branch branch = branchRepository.findById(counterMapCreateDto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        List<CounterMap> existingMaps = counterMapRepository.findByLayerAndBranchDeptId(counterMapCreateDto.getLayer(), branch.getDeptId());
        if (!existingMaps.isEmpty()) {
            throw new RuntimeException("Layer value already exists for this branch");
        }

        // CounterMap 생성
        CounterMap counterMap = new CounterMap();
        counterMap.setLayer(counterMapCreateDto.getLayer());
        counterMap.setWidth(counterMapCreateDto.getWidth());
        counterMap.setHeight(counterMapCreateDto.getHeight());
        counterMap.setBranch(branch); // Branch 설정

        // 카운터 맵 저장
        CounterMap savedCounterMap = counterMapRepository.save(counterMap);

        // DTO로 변환하여 반환
        return CounterMapResponseDto.toDto(savedCounterMap);
    }

    @Override
    @Transactional
    public CounterMap updateCounterMap(CounterMapUpdateDto counterMapUpdateDto) {
        // CounterMap 조회
        CounterMap counterMap = counterMapRepository.findById(counterMapUpdateDto.getWdMapId())
                .orElseThrow(() -> new RuntimeException("CounterMap not found"));

        // width와 height 업데이트
        counterMap.setWidth(counterMapUpdateDto.getWidth());
        counterMap.setHeight(counterMapUpdateDto.getHeight());

        // 기존 CounterMapItem 삭제
        List<CounterMapItem> existingItems = counterMap.getCounterMapItems();
        existingItems.clear(); // 기존 데이터 비우기

        // 새로운 CounterMapItem 추가
        for (CounterMapItemUpdateDto itemDto : counterMapUpdateDto.getCounterMapItemUpdateDtos()) {
            CounterMapItem newItem = new CounterMapItem();
            newItem.setWdId(itemDto.getWdId());
            newItem.setName(itemDto.getName());
            newItem.setColor(itemDto.getColor());
            newItem.setX(itemDto.getX());
            newItem.setY(itemDto.getY());
            newItem.setCounterMap(counterMap); // CounterMap 설정

            existingItems.add(newItem); // 새로운 아이템 추가
        }

        // CounterMap 저장 (CascadeType.ALL로 인해 CounterMapItem도 함께 저장됨)
        return counterMapRepository.save(counterMap);
    }

    @Override
    public void deleteCounterMap(Long wdMapId) {
        // CounterMap 조회
        CounterMap counterMap = counterMapRepository.findById(wdMapId)
                .orElseThrow(() -> new RuntimeException("CounterMap not found"));

        // CounterMap 삭제
        counterMapRepository.delete(counterMap);
    }


}

package com.imkiosk.imkiosk.api.service.counter;

import com.imkiosk.imkiosk.api.dto.branch.BranchCounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapCreateDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapItemUpdateDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapResponseDto;
import com.imkiosk.imkiosk.api.dto.counter.CounterMapUpdateDto;
import com.imkiosk.imkiosk.api.entity.branch.Branch;
import com.imkiosk.imkiosk.api.entity.counter.CounterMap;
import com.imkiosk.imkiosk.api.entity.counter.CounterMapItem;
import com.imkiosk.imkiosk.api.repository.branch.BranchRepository;
import com.imkiosk.imkiosk.api.repository.counter.CounterMapRepository;
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
                .map(CounterMapResponseDto::toDto)
                .collect(Collectors.toList());

        return BranchCounterMapResponseDto.toDto(deptId, counterMapResponseDtos);
    }

    @Override
    @Transactional
    public CounterMapResponseDto createCounterMap(CounterMapCreateDto counterMapCreateDto) {
        Branch branch = branchRepository.findById(counterMapCreateDto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        List<CounterMap> existingMaps = counterMapRepository.findByLayerAndBranchDeptId(counterMapCreateDto.getLayer(), branch.getDeptId());
        if (!existingMaps.isEmpty()) {
            throw new RuntimeException("Layer value already exists for this branch");
        }

        CounterMap counterMap = new CounterMap();
        counterMap.setLayer(counterMapCreateDto.getLayer());
        counterMap.setWidth(counterMapCreateDto.getWidth());
        counterMap.setHeight(counterMapCreateDto.getHeight());
        counterMap.setBranch(branch); // Branch 설정

        CounterMap savedCounterMap = counterMapRepository.save(counterMap);

        return CounterMapResponseDto.toDto(savedCounterMap);
    }

    @Override
    @Transactional
    public CounterMap updateCounterMap(CounterMapUpdateDto counterMapUpdateDto) {
        CounterMap counterMap = counterMapRepository.findById(counterMapUpdateDto.getWdMapId())
                .orElseThrow(() -> new RuntimeException("CounterMap not found"));

        counterMap.setWidth(counterMapUpdateDto.getWidth());
        counterMap.setHeight(counterMapUpdateDto.getHeight());

        List<CounterMapItem> existingItems = counterMap.getCounterMapItems();
        existingItems.clear();

        for (CounterMapItemUpdateDto itemDto : counterMapUpdateDto.getCounterMapItemUpdateDtos()) {
            CounterMapItem newItem = new CounterMapItem();
            newItem.setWdId(itemDto.getWdId());
            newItem.setName(itemDto.getName());
            newItem.setColor(itemDto.getColor());
            newItem.setX(itemDto.getX());
            newItem.setY(itemDto.getY());
            newItem.setCounterMap(counterMap);

            existingItems.add(newItem);
        }

        return counterMapRepository.save(counterMap);
    }

    @Override
    public void deleteCounterMap(Long wdMapId) {
        CounterMap counterMap = counterMapRepository.findById(wdMapId)
                .orElseThrow(() -> new RuntimeException("CounterMap not found"));

        counterMapRepository.delete(counterMap);
    }


}

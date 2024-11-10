package com.imkiosk.imkiosk.api.service.hisotry;

import com.imkiosk.imkiosk.api.entity.history.History;
import com.imkiosk.imkiosk.api.repository.history.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;


    @Override
    public List<History> getHistoriesByDeptAndDateRange(Long deptId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return historyRepository.findByDeptIdAndCurrentDateTimeBetween(deptId, startDateTime, endDateTime);
    }
}

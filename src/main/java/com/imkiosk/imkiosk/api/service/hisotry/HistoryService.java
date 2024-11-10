package com.imkiosk.imkiosk.api.service.hisotry;

import com.imkiosk.imkiosk.api.entity.history.History;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryService {
    List<History> getHistoriesByDeptAndDateRange(Long deptId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}

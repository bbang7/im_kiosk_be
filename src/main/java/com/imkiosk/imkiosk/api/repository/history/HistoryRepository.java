package com.imkiosk.imkiosk.api.repository.history;

import com.imkiosk.imkiosk.api.entity.history.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findByDeptIdAndCurrentDateTimeBetween(Long deptId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}

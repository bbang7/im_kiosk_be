package com.imkiosk.imkiosk.api.repository.history;

import com.imkiosk.imkiosk.api.entity.history.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Long> {
}

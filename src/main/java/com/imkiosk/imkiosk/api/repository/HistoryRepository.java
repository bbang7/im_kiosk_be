package com.imkiosk.imkiosk.api.repository;

import com.imkiosk.imkiosk.api.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Long> {
}

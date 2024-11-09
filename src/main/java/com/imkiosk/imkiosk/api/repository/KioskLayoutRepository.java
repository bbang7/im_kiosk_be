package com.imkiosk.imkiosk.api.repository;

import com.imkiosk.imkiosk.api.entity.KioskLayout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KioskLayoutRepository extends JpaRepository<KioskLayout, Long> {
    List<KioskLayout> findByBranch_DeptId(Long deptId);

}

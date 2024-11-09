package com.imkiosk.imkiosk.api.repository;

import com.imkiosk.imkiosk.api.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
    List<Counter> findByBranch_DeptId(Long deptId);
    Optional<Counter> findByWdName(String wdName);
    Optional<Counter> findByWdNameAndBranchDeptId(String wdName, Long deptId);

}

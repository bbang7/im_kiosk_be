package com.imkiosk.imkiosk.api.repository.counter;

import com.imkiosk.imkiosk.api.entity.counter.CounterMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterMapRepository extends JpaRepository<CounterMap, Long> {
    List<CounterMap> findByBranchDeptId(Long deptId);
    List<CounterMap> findByLayerAndBranchDeptId(Byte layer, Long deptId);
}

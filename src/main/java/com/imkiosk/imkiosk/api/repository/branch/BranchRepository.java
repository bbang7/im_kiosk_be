package com.imkiosk.imkiosk.api.repository.branch;

import com.imkiosk.imkiosk.api.entity.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch,Long> {
    Optional<Branch> findByDeptId(Long deptId);
}

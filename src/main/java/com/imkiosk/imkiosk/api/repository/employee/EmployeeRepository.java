package com.imkiosk.imkiosk.api.repository.employee;

import com.imkiosk.imkiosk.api.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByMemberCode(String memberCode);
}


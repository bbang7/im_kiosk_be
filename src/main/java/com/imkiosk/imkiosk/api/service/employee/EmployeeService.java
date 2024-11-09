package com.imkiosk.imkiosk.api.service.employee;


import com.imkiosk.imkiosk.api.dto.employee.EmployeeCreateDto;
import com.imkiosk.imkiosk.api.dto.employee.LoginRequestDto;
import com.imkiosk.imkiosk.api.dto.employee.LoginResponseDto;

public interface EmployeeService {
    LoginResponseDto validateMember(LoginRequestDto loginRequestDto);
    void createEmployee(EmployeeCreateDto employeeCreateDto);
}

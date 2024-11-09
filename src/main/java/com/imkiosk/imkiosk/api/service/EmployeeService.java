package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.EmployeeCreateDto;
import com.imkiosk.imkiosk.api.dto.LoginRequestDto;
import com.imkiosk.imkiosk.api.dto.LoginResponseDto;

public interface EmployeeService {
    LoginResponseDto validateMember(LoginRequestDto loginRequestDto);
    void createEmployee(EmployeeCreateDto employeeCreateDto);
}

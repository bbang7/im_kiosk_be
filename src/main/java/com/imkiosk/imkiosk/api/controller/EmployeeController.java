package com.imkiosk.imkiosk.api.controller;


import com.imkiosk.imkiosk.api.dto.EmployeeCreateDto;
import com.imkiosk.imkiosk.api.dto.LoginRequestDto;
import com.imkiosk.imkiosk.api.dto.LoginResponseDto;
import com.imkiosk.imkiosk.api.entity.Employee;
import com.imkiosk.imkiosk.api.service.EmployeeServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/login")
    public BaseResponse<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = employeeServiceImpl.validateMember(loginRequestDto);
        return new BaseResponse<>(loginResponseDto);
    }

    @PostMapping("/employee")
    public BaseResponse<Employee> createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        employeeServiceImpl.createEmployee(employeeCreateDto);
        return new BaseResponse<>();
    }
}


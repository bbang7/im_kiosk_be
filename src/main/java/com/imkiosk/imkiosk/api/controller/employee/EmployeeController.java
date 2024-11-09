package com.imkiosk.imkiosk.api.controller.employee;


import com.imkiosk.imkiosk.api.dto.employee.EmployeeCreateDto;
import com.imkiosk.imkiosk.api.dto.employee.LoginRequestDto;
import com.imkiosk.imkiosk.api.dto.employee.LoginResponseDto;
import com.imkiosk.imkiosk.api.entity.employee.Employee;
import com.imkiosk.imkiosk.api.service.employee.EmployeeServiceImpl;
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


package com.imkiosk.imkiosk.api.dto;

import com.imkiosk.imkiosk.api.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String memberCode;
    private String memberName;
    private Long deptId;
    private String deptName;
    private String rule;

    public static LoginResponseDto toDto(Employee employee){
    return LoginResponseDto.builder()
            .memberCode(employee.getMemberCode())
            .memberName(employee.getMemberName())
            .deptId(employee.getBranch() != null ? employee.getBranch().getDeptId() : null)
            .deptName(employee.getBranch() != null ? employee.getBranch().getDeptName() : null)
            .rule(employee.getRule().getDisplayName())
            .build();
    }


}

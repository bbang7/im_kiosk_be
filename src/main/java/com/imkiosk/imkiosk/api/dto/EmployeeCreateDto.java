package com.imkiosk.imkiosk.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDto {
    private String memberCode;
    private Long deptId;
    private String password;
    private String memberName;
    private String memberDvcd;
    private Byte rule;
}

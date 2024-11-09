package com.imkiosk.imkiosk.api.dto.employee;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String id;
    private String password;
}

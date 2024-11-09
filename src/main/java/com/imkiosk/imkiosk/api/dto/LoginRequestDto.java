package com.imkiosk.imkiosk.api.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String id;
    private String password;
}

package com.imkiosk.imkiosk.api.dto.branch;

import lombok.Data;

@Data
public class BranchRequestDto {
    private String deptName;
    private String sTime;
    private String eTime;
}

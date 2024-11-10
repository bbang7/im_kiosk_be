package com.imkiosk.imkiosk.api.dto.branch;

import com.imkiosk.imkiosk.api.entity.branch.Branch;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchInfoResponseDto {
    private Long deptId;
    private String deptName;
    private String stime;
    private String etime;

    public static BranchInfoResponseDto toDto(Branch branch){
        return BranchInfoResponseDto.builder()
                .deptId(branch.getDeptId())
                .deptName(branch.getDeptName())
                .stime(branch.getStime())
                .etime(branch.getEtime())
                .build();
    }
}

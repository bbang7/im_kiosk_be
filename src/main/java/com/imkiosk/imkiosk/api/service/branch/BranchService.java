package com.imkiosk.imkiosk.api.service.branch;


import com.imkiosk.imkiosk.api.dto.branch.BranchInfoResponseDto;
import com.imkiosk.imkiosk.api.dto.branch.BranchRequestDto;

import java.util.List;

public interface BranchService {
    void createBranch(BranchRequestDto branchRequestDto);
    List<BranchInfoResponseDto> getBranchInfoList();
}

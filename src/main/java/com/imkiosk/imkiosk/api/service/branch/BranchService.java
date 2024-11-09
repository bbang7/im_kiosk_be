package com.imkiosk.imkiosk.api.service.branch;


import com.imkiosk.imkiosk.api.dto.branch.BranchRequestDto;

public interface BranchService {
    void createBranch(BranchRequestDto branchRequestDto);
}

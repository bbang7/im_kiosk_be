package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.BranchRequestDto;

public interface BranchService {
    void createBranch(BranchRequestDto branchRequestDto);
}

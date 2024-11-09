package com.imkiosk.imkiosk.api.controller;

import com.imkiosk.imkiosk.api.dto.BranchRequestDto;
import com.imkiosk.imkiosk.api.service.BranchServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
    @Autowired
    BranchServiceImpl branchServiceImpl;

    @PostMapping("/branch")
    public BaseResponse<Void> createBranch(@RequestBody BranchRequestDto branchRequestDto) {
        branchServiceImpl.createBranch(branchRequestDto);
        return new BaseResponse<>();
    }
}

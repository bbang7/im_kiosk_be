package com.imkiosk.imkiosk.api.controller.branch;

import com.imkiosk.imkiosk.api.dto.branch.BranchInfoResponseDto;
import com.imkiosk.imkiosk.api.dto.branch.BranchRequestDto;
import com.imkiosk.imkiosk.api.service.branch.BranchServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    BranchServiceImpl branchServiceImpl;

    @PostMapping("/branch")
    public BaseResponse<Void> createBranch(@RequestBody BranchRequestDto branchRequestDto) {
        branchServiceImpl.createBranch(branchRequestDto);
        return new BaseResponse<>();
    }

    @GetMapping("/branch")
    public BaseResponse<List<BranchInfoResponseDto>> getBranchInfoList(){
        List<BranchInfoResponseDto> branchInfoResponseDtos = branchServiceImpl.getBranchInfoList();
        return new BaseResponse<>(branchInfoResponseDtos);

    }
}

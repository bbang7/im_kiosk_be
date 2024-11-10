package com.imkiosk.imkiosk.api.service.branch;


import com.imkiosk.imkiosk.api.dto.branch.BranchInfoResponseDto;
import com.imkiosk.imkiosk.api.dto.branch.BranchRequestDto;
import com.imkiosk.imkiosk.api.entity.branch.Branch;
import com.imkiosk.imkiosk.api.repository.branch.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public void createBranch(BranchRequestDto branchRequestDto) {
        if (branchRequestDto.getDeptName() == null || branchRequestDto.getDeptName().isEmpty()) {
            throw new RuntimeException("Department name cannot be null or empty.");
        }

        Branch branch = new Branch();
        branch.setDeptName(branchRequestDto.getDeptName());
        branch.setStime(branchRequestDto.getSTime());
        branch.setEtime(branchRequestDto.getETime());

        branchRepository.save(branch);
    }

    @Override
    public List<BranchInfoResponseDto> getBranchInfoList() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(BranchInfoResponseDto::toDto).collect(Collectors.toList());
    }
}

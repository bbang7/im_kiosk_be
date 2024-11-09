package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.BranchRequestDto;
import com.imkiosk.imkiosk.api.entity.Branch;
import com.imkiosk.imkiosk.api.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

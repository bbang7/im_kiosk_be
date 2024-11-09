package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.CommonButtonDto;
import com.imkiosk.imkiosk.api.entity.Branch;
import com.imkiosk.imkiosk.api.entity.CommonButton;
import com.imkiosk.imkiosk.api.entity.KioskLayout;
import com.imkiosk.imkiosk.api.repository.BranchRepository;
import com.imkiosk.imkiosk.api.repository.CommonButtonRepository;
import com.imkiosk.imkiosk.api.repository.KioskLayoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommonButtonServiceImpl implements CommonButtonService {

    private final CommonButtonRepository commonButtonRepository;
    private final BranchRepository branchRepository;
    private final KioskLayoutRepository kioskLayoutRepository;

    @Override
    @Transactional
    public void createCommonButton(CommonButtonDto commonButtonDto) {
        Branch branch = branchRepository.findById(commonButtonDto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Branch not found: " + commonButtonDto.getDeptId())); // 예외 처리

        CommonButton commonButton = new CommonButton();
        commonButton.setBranch(branch); // Branch 설정
        commonButton.setItemName(commonButtonDto.getItemName());

        commonButtonRepository.save(commonButton);

        // 초기 인덱스를 설정해줘야할까?
        KioskLayout kioskLayout = new KioskLayout();
        kioskLayout.setBranch(commonButton.getBranch());
        kioskLayout.setCommonItemId(commonButton.getCommonItemId());
        kioskLayout.setIsCommon(true);
        kioskLayout.setName(commonButton.getItemName());
        kioskLayout.setIsPlaced(false);

        kioskLayoutRepository.save(kioskLayout);

    }
}

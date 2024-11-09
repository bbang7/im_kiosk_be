package com.imkiosk.imkiosk.api.service.employee;


import com.imkiosk.imkiosk.api.dto.employee.EmployeeCreateDto;
import com.imkiosk.imkiosk.api.dto.employee.LoginRequestDto;
import com.imkiosk.imkiosk.api.dto.employee.LoginResponseDto;
import com.imkiosk.imkiosk.api.entity.branch.Branch;
import com.imkiosk.imkiosk.api.entity.employee.Employee;
import com.imkiosk.imkiosk.api.entity.employee.RuleType;
import com.imkiosk.imkiosk.api.repository.branch.BranchRepository;
import com.imkiosk.imkiosk.api.repository.employee.EmployeeRepository;
import com.imkiosk.imkiosk.common.entity.BaseResponseStatus;
import com.imkiosk.imkiosk.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;

    @Override
    @Transactional
    public LoginResponseDto validateMember(LoginRequestDto loginRequestDto) {
        // 사용자 조회
        Employee employee = employeeRepository.findByMemberCode(loginRequestDto.getId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 입력한 비밀번호와 저장된 해시 비밀번호 비교

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), employee.getPassword())) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }

        return LoginResponseDto.toDto(employee);
    }

    @Override
    public void createEmployee(EmployeeCreateDto employeeCreateDto) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(employeeCreateDto.getPassword());

        Employee employee = new Employee();
        employee.setMemberCode(employeeCreateDto.getMemberCode());
        employee.setMemberName(employeeCreateDto.getMemberName());
        employee.setPassword(hashedPassword);
        employee.setMemberDvcd(employeeCreateDto.getMemberDvcd());

        employee.setRule(RuleType.fromCode(employeeCreateDto.getRule()));

        if (employeeCreateDto.getDeptId() != null) {
            Branch branch = branchRepository.findById(employeeCreateDto.getDeptId())
                    .orElseThrow(() -> new RuntimeException("Branch not found"));
            employee.setBranch(branch);
        }
        employeeRepository.save(employee);

        return;
    }

}

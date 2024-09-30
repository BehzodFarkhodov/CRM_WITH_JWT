package uz.pdp.pdp_crmwithjwt.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_crmwithjwt.controller.exception.DataNotFoundException;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.StaffResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.DepartmentEntity;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.UserRole;
import uz.pdp.pdp_crmwithjwt.repository.StaffRepository;

import java.util.List;
import java.util.UUID;

@Service
public class
StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Lazy
    private DepartmentService departmentService;

    public StaffResponse save(StaffEntity staff) {
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return modelMapper.map(staffRepository.save(staff), StaffResponse.class);
    }

    public StaffEntity update(StaffEntity update) {
        return staffRepository.save(update);
    }


    public StaffEntity findByUsername(String username) {
        return staffRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

    public List<StaffEntity> findAll() {
        return staffRepository.findAll();
    }

    public List<StaffResponse> findDepartmentHeads() {
        return mapEntitiesToResponse(staffRepository.findByRole(UserRole.DEPARTMENT_HEAD));
    }

    public List<StaffResponse> findFreeDepartmentHeads() {
        return findByRoleAndDepartmentIsNull(UserRole.DEPARTMENT_HEAD);
    }

    public List<StaffResponse> findByRoleAndDepartmentIsNull(UserRole role) {
        return mapEntitiesToResponse(staffRepository.findByRoleAndDepartmentIsNull(role));
    }

    public void assignDepartment(UUID staffId, UUID departmentId) {
        StaffEntity staff = findById(staffId);

        if(staff.getRole() == UserRole.DEPARTMENT_HEAD) {
            departmentService.assignHead(departmentId, staffId);
        } else {
            staff.setDepartment(departmentService.findById(departmentId));
            staffRepository.save(staff);
        }
    }

    public void delete(UUID staffId) {
        StaffEntity staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new DataNotFoundException("department not found"));
        DepartmentEntity department = staff.getDepartment();
        department.setHead(null);
        staff.setDepartment(null);
        departmentService.update(department);
        staffRepository.delete(staff);
    }

    public List<StaffResponse> mapEntitiesToResponse(List<StaffEntity> staffEntities) {
        return modelMapper.map(staffEntities,
                new TypeReference<List<StaffResponse>> (){}.getType());
    }

    public StaffEntity findById(UUID id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("department not found"));
    }
}

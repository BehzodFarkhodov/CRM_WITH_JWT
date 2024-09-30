package uz.pdp.pdp_crmwithjwt.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_crmwithjwt.controller.exception.DataNotFoundException;
import uz.pdp.pdp_crmwithjwt.domain.dto.request.DepartmentRequest;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.DepartmentResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.DepartmentEntity;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;
import uz.pdp.pdp_crmwithjwt.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StaffService staffService;

    public DepartmentResponse save(DepartmentRequest departmentRequest) {
        DepartmentEntity department = modelMapper.map(departmentRequest, DepartmentEntity.class);

        if (Objects.nonNull(departmentRequest.getHeadId())) {
            StaffEntity head = staffService.findById(departmentRequest.getHeadId());
            department.setHead(head);
            head.setDepartment(department);
            departmentRepository.save(department);
            staffService.update(head);
        } else {
            departmentRepository.save(department);
        }

         return modelMapper.map(
                department,
                DepartmentResponse.class);
    }

    public DepartmentEntity update(DepartmentEntity entity) {
        return departmentRepository.save(entity);
    }
    public List<DepartmentResponse> findAll() {
        return modelMapper.map(departmentRepository.findAll(),
                new TypeReference<List<DepartmentResponse>>() {
                }.getType());
    }

    public List<DepartmentResponse> findAllWithoutHead() {
        return modelMapper.map(departmentRepository.findAllByHeadIsNull(),
                new TypeReference<List<DepartmentResponse>>() {
                }.getType());
    }

    public DepartmentEntity findById(UUID id) {
        return departmentRepository.findById(id)
                        .orElseThrow(() -> new DataNotFoundException("department not found"));
    }

    public DepartmentResponse findByName(String name) {
        return modelMapper.map(
                departmentRepository.findByName(name)
                        .orElseThrow(() -> new DataNotFoundException("department not found")),
                DepartmentResponse.class);
    }


    public void assignHead(UUID departmentId, UUID headId) {
        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DataNotFoundException("department not found"));
        StaffEntity head = staffService.findById(headId);
        head.setId(headId);
        department.setHead(head);
        head.setDepartment(department);
        staffService.update(head);
        departmentRepository.save(department);
    }

    public void delete(UUID id) {
        DepartmentEntity department = departmentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("department not found"));
        StaffEntity head = department.getHead();
        department.setHead(null);
        head.setDepartment(null);
        staffService.update(head);
        departmentRepository.delete(department);
    }
}

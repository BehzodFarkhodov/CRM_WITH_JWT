package uz.pdp.pdp_crmwithjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_crmwithjwt.domain.dto.request.DepartmentRequest;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.DepartmentResponse;
import uz.pdp.pdp_crmwithjwt.service.DepartmentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping
    public List<DepartmentResponse> departments() {
        return departmentService.findAllWithoutHead();
    }

    @PostMapping("/add")
    public DepartmentResponse create(@RequestBody DepartmentRequest departmentRequest) {
        return departmentService.save(departmentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        departmentService.delete(id);
    }
}

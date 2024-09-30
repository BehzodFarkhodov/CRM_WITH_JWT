package uz.pdp.pdp_crmwithjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.StaffResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.UserRole;
import uz.pdp.pdp_crmwithjwt.service.StaffService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/api")
    public List<String> getFreeHeadList() {
        return List.of("hahaha", "hiihihihi");
    }


//    @GetMapping()
//    public String staffPage(@AuthenticationPrincipal StaffEntity currentUser, Model model) {
//        model.addAttribute("departmentHeads", staffService.findDepartmentHeads());
//        model.addAttribute("role", UserRole.DEPARTMENT_HEAD);
//        return "superadmin/staff";
//    }

    @PostMapping("/add")
    public void addStaff(@RequestBody StaffEntity staff) {
        staffService.save(staff);
    }

    @DeleteMapping("/delete/{staffId}")
    public void deleteStaff(@PathVariable UUID staffId) {
        staffService.delete(staffId);
    }

    @PostMapping("/assign-department")
    public String assignDepartment( UUID staffId, UUID departmentId) {
        staffService.assignDepartment(staffId, departmentId);
        return "redirect:/staff";
    }
}

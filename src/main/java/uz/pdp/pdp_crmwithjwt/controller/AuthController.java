package uz.pdp.pdp_crmwithjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_crmwithjwt.domain.dto.request.LoginDto;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.JwtResponse;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.StaffResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;
import uz.pdp.pdp_crmwithjwt.service.AuthService;
import uz.pdp.pdp_crmwithjwt.service.StaffService;

@RestController
public class AuthController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public StaffResponse register(@RequestBody StaffEntity staff) {
        return staffService.save(staff);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
}

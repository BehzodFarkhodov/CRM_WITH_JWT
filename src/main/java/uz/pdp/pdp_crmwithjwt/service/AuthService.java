package uz.pdp.pdp_crmwithjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_crmwithjwt.domain.dto.request.LoginDto;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.JwtResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;
import uz.pdp.pdp_crmwithjwt.repository.StaffRepository;

@Service
public class AuthService {

    @Autowired
    private StaffService staffService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public JwtResponse login(LoginDto loginDto) {
        StaffEntity staff = staffService.findByUsername(loginDto.getUsername());
        if(passwordEncoder.matches(loginDto.getPassword(), staff.getPassword())) {
            return new JwtResponse(jwtService.generateToken(staff));
        }
        throw new UsernameNotFoundException("Wrong username or password");
    }

}

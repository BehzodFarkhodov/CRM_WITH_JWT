package uz.pdp.pdp_crmwithjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.pdp.pdp_crmwithjwt.filter.JwtFilter;
import uz.pdp.pdp_crmwithjwt.service.AuthService;


@Configuration
//@EnableMethodSecurity
public class SecurityConfig {
    private final String[] WHITE_LIST = {"/register", "/login", "/"};

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeHttpRequestsConfigurer) -> {
                    authorizeHttpRequestsConfigurer
                            .requestMatchers("/css/**", "/js/**").permitAll()
                            .requestMatchers(WHITE_LIST).permitAll()
//                            .requestMatchers("/department/**").hasRole("SUPER_ADMIN")
                            .anyRequest().authenticated();
                })
                .addFilterBefore(jwtFilter,
                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
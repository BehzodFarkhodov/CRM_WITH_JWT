package uz.pdp.pdp_crmwithjwt.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;

import java.util.Optional;
import java.util.UUID;

@Component(value = "myAuditing")
public class CustomAuditing implements AuditorAware<UUID> {
    @Override
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.empty();
        }
        return Optional.of(((StaffEntity) authentication.getPrincipal()).getId());
    }
}

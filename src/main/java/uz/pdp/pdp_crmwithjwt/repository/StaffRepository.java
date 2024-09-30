package uz.pdp.pdp_crmwithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {

    Optional<StaffEntity> findByUsername(String username);

    List<StaffEntity> findByRole(UserRole role);

    List<StaffEntity> findByRoleAndDepartmentIsNull(UserRole role);

}

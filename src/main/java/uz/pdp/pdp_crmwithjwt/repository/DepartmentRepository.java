package uz.pdp.pdp_crmwithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_crmwithjwt.domain.entity.DepartmentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, UUID> {


    Optional<DepartmentEntity> findByName(String name);

    List<DepartmentEntity> findAllByHeadIsNull();
}

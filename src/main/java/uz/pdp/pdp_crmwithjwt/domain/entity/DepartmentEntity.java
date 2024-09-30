package uz.pdp.pdp_crmwithjwt.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "department")
    private List<StaffEntity> staff;
    @OneToOne(cascade = CascadeType.PERSIST)
    private StaffEntity head;

}

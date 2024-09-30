package uz.pdp.pdp_crmwithjwt.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.GroupType;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.Shift;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    private LocalDate startDate;
    @Enumerated(EnumType.STRING)
    private Shift shift;

    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    private Integer duration;
    private boolean isStopped;

    @ManyToOne
    public StaffEntity mentor;

    @OneToMany(mappedBy = "group")
    private List<ModuleEntity> modules;

}

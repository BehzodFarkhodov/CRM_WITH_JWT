package uz.pdp.pdp_crmwithjwt.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "modules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleEntity extends BaseEntity {
    private Integer number;
    private String title;

    @ManyToOne
    private GroupEntity group;

    @OneToMany(mappedBy = "module")
    private List<LessonEntity> lessons;
}

package uz.pdp.pdp_crmwithjwt.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonEntity extends BaseEntity {
    private Integer number;
    private String title;


    @ManyToOne
    private ModuleEntity module;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<AttendanceEntity> attendances;
}

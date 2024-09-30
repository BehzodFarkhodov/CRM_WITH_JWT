package uz.pdp.pdp_crmwithjwt.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "attendances")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceEntity extends BaseEntity {
    @ManyToOne
    private StudentEntity studentEntity;

    @ManyToOne
    private LessonEntity lesson;
    private boolean isAbsent;
    private String reason;
}

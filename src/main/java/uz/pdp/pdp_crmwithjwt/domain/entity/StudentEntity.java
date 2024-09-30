package uz.pdp.pdp_crmwithjwt.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity extends BaseEntity {
    private String fullName;
    private String email;
    private LocalDate birthDate;

    @ManyToOne
    private GroupEntity group;



}

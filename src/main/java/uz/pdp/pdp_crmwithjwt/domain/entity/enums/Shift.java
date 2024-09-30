package uz.pdp.pdp_crmwithjwt.domain.entity.enums;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public enum Shift {
    MORNING(LocalTime.of(9, 0, 0), LocalTime.of(8, 30, 0)),
    AFTERNOON(LocalTime.of(15, 0, 0), LocalTime.of(14, 30, 0)),
    EVENING(LocalTime.of(18, 0, 0), null);

    private final LocalTime startNormal;
    private final LocalTime startBootcamp;


    Shift(LocalTime startNormal, LocalTime startBootcamp) {
        this.startNormal = startNormal;
        this.startBootcamp = startBootcamp;
    }
}

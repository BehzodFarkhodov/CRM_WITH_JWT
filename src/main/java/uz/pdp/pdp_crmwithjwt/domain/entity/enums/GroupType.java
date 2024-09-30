package uz.pdp.pdp_crmwithjwt.domain.entity.enums;

import lombok.Getter;

@Getter
public enum GroupType {

    NORMAL(3),
    BOOTCAMP(4);
//    in hours
    private final int duration;

    GroupType(int duration) {
        this.duration = duration;
    }
}

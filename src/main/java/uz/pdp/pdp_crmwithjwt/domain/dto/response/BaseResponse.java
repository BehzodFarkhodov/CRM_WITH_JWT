package uz.pdp.pdp_crmwithjwt.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BaseResponse {
    protected UUID id;
    protected LocalDateTime modified;
    protected LocalDateTime created;
    protected UUID createdBy;
    protected UUID modifiedBy;
}

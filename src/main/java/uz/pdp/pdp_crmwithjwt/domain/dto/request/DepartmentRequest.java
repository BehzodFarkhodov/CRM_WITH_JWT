package uz.pdp.pdp_crmwithjwt.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentRequest {
    private String name;
    private UUID headId;
}

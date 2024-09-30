package uz.pdp.pdp_crmwithjwt.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentResponse extends BaseResponse {
    private String name;
    private String headName;
    private UUID headId;
}

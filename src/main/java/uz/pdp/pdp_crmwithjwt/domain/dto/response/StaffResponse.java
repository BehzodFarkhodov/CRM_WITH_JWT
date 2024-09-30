package uz.pdp.pdp_crmwithjwt.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.RolePermission;
import uz.pdp.pdp_crmwithjwt.domain.entity.enums.UserRole;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffResponse extends BaseResponse {
    private String username;
    private String fullName;
    private String departmentName;
    private UserRole role;
    private List<RolePermission> permissions;
}

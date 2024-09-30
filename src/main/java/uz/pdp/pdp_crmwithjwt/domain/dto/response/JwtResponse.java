package uz.pdp.pdp_crmwithjwt.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponse {
//    public JwtResponse(String token) {
//        this.token = token;
//    }

    private String token;
}

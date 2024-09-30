package uz.pdp.pdp_crmwithjwt.domain.dto.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.StaffResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.StaffEntity;

public class StaffEntityToStaffResponse implements Converter<StaffEntity, StaffResponse> {

    @Override
    public StaffResponse convert(MappingContext<StaffEntity, StaffResponse> context) {
        StaffEntity source = context.getSource();
        StaffResponse destination = new StaffResponse();

        destination.setId(source.getId());
        destination.setCreated(source.getCreated());
        destination.setModified(source.getModified());
        destination.setCreatedBy(source.getCreatedBy());
        destination.setModifiedBy(source.getModifiedBy());

        destination.setUsername(source.getUsername());
        destination.setFullName(source.getFullName());
        destination.setRole(source.getRole());
        destination.setPermissions(source.getPermissions());
        // Check for null and set department name
        if (source.getDepartment() != null) {
            destination.setDepartmentName(source.getDepartment().getName());
        }

        return destination;
    }
}

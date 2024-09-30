package uz.pdp.pdp_crmwithjwt.domain.dto.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import uz.pdp.pdp_crmwithjwt.domain.dto.response.DepartmentResponse;
import uz.pdp.pdp_crmwithjwt.domain.entity.DepartmentEntity;

public class DepartmentEntityToDepartmentResponse implements Converter<DepartmentEntity, DepartmentResponse> {
    @Override
    public DepartmentResponse convert(MappingContext<DepartmentEntity, DepartmentResponse> mappingContext) {
        DepartmentEntity source = mappingContext.getSource();
        DepartmentResponse destination = new DepartmentResponse();

        destination.setId(source.getId());
        destination.setCreated(source.getCreated());
        destination.setModified(source.getModified());
        destination.setCreatedBy(source.getCreatedBy());
        destination.setModifiedBy(source.getModifiedBy());

        destination.setName(source.getName());

        // Check for null and set department name
        if (source.getHead() != null) {
            destination.setHeadName(source.getHead().getFullName());
            destination.setHeadId(source.getHead().getId());
        }
        return destination;
    }
}

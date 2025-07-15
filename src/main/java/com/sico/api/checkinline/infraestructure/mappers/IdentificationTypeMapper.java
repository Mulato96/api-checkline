package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.IdentificationTypeEntity;
import com.sico.api.checkinline.domain.models.identificationtype.IdentificationType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IdentificationTypeMapper extends
    EntityMapper<IdentificationType, IdentificationTypeEntity> {

}

package com.sico.api.checkinline.infraestructure.mappers.naturalpersonregistration;

import com.sico.api.checkinline.domain.entities.naturalpersonregistration.NaturalPersonRegistrationEntity;
import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NaturalPersonRegistrationMapper extends EntityMapper<NaturalPersonRegistration, NaturalPersonRegistrationEntity> {
}

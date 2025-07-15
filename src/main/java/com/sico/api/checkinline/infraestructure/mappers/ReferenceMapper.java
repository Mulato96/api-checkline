package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.ReferenceEntity;
import com.sico.api.checkinline.domain.models.general.report.Reference;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReferenceMapper extends EntityMapper<Reference, ReferenceEntity> {

}

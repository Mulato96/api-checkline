package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.ExecutiveEntity;
import com.sico.api.checkinline.domain.models.general.report.Executive;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExecutiveMapper extends EntityMapper<Executive, ExecutiveEntity> {
}

package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.LinkedEntity;
import com.sico.api.checkinline.domain.models.general.report.Linked;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LinkedMapper extends EntityMapper<Linked, LinkedEntity> {
}

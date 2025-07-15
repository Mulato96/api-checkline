package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.models.general.report.Renewal;
import com.sico.api.checkinline.domain.entities.RenewalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RenewalMapper extends EntityMapper<Renewal, RenewalEntity> {
}

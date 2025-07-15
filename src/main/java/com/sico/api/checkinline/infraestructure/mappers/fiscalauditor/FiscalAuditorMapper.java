package com.sico.api.checkinline.infraestructure.mappers.fiscalauditor;

import com.sico.api.checkinline.domain.entities.FiscalAuditorEntity;
import com.sico.api.checkinline.domain.models.fiscalauditor.FiscalAuditor;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FiscalAuditorMapper extends EntityMapper<FiscalAuditor, FiscalAuditorEntity> {
}

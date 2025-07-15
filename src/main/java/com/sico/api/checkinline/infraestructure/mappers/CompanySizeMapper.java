package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanySizeEntity;
import com.sico.api.checkinline.domain.models.general.report.CompanySize;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanySizeMapper extends EntityMapper<CompanySize, CompanySizeEntity> {
}

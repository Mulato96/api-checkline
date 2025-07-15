package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanySearchFilterEntity;
import com.sico.api.checkinline.domain.models.general.CompanySearchFilter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanySearchFilterMapper extends EntityMapper<CompanySearchFilterEntity, CompanySearchFilter> {
}

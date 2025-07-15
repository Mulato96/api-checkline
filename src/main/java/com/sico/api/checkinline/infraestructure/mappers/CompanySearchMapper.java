package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanySearchEntity;
import com.sico.api.checkinline.domain.models.general.search.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanySearchMapper extends EntityMapper<Company, CompanySearchEntity> {
}

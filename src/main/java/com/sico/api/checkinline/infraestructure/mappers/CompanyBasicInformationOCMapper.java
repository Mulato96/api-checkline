package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanyBasicInformationOCEntity;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyBasicInformationOCMapper extends EntityMapper<CompanyBasicInformationOC, CompanyBasicInformationOCEntity> {
}

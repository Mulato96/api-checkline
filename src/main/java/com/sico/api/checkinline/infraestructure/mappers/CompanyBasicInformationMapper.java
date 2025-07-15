package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanyBasicInformationEntity;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyBasicInformationMapper
        extends EntityMapper<CompanyBasicInformation, CompanyBasicInformationEntity> {
}

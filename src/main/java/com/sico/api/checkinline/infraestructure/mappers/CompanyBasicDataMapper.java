package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanyBasicDataEntity;
import com.sico.api.checkinline.domain.models.general.CompanyBasicData;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyBasicDataMapper extends EntityMapper<CompanyBasicData, CompanyBasicDataEntity> {
}

package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.models.general.report.GeneralInformation;
import com.sico.api.checkinline.domain.entities.GeneralInformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GeneralInformationMapper extends EntityMapper<GeneralInformation, GeneralInformationEntity> {
}

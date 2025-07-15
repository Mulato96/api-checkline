package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.CompanyInformationEntity;
import com.sico.api.checkinline.domain.models.general.report.CompanyInformation;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyInformationMapper extends EntityMapper<CompanyInformation, CompanyInformationEntity> {

}


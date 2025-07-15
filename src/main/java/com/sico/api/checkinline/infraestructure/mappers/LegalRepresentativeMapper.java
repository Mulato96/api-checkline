package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.models.general.report.LegalRepresentative;
import com.sico.api.checkinline.domain.entities.LegalRepresentativeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LegalRepresentativeMapper extends EntityMapper<LegalRepresentative, LegalRepresentativeEntity> {
}

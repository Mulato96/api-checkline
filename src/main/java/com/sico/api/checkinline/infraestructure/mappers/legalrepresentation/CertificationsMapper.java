package com.sico.api.checkinline.infraestructure.mappers.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificationsEntity;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certifications;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CertificationsMapper extends EntityMapper<Certifications, CertificationsEntity> {
}

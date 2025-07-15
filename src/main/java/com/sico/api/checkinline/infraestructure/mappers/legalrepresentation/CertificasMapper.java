package com.sico.api.checkinline.infraestructure.mappers.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificasEntity;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CertificasMapper extends EntityMapper<Certificas, CertificasEntity> {
}

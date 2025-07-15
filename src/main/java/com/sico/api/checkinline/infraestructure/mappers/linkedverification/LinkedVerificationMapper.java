package com.sico.api.checkinline.infraestructure.mappers.linkedverification;

import com.sico.api.checkinline.domain.entities.linkedverification.LinkedVerificationEntity;
import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LinkedVerificationMapper  extends EntityMapper<LinkedVerification, LinkedVerificationEntity> {
}

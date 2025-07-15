package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.AssociatedEstablishmentEntity;
import com.sico.api.checkinline.domain.models.general.report.AssociatedEstablishment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssociatedEstablishmentMapper extends EntityMapper<AssociatedEstablishment, AssociatedEstablishmentEntity> {
}

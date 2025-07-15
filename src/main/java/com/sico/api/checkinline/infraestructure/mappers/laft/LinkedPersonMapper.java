package com.sico.api.checkinline.infraestructure.mappers.laft;

import com.sico.api.checkinline.domain.entities.laft.LinkedPersonEntity;
import com.sico.api.checkinline.domain.models.laft.LinkedPerson;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LinkedPersonMapper extends EntityMapper<LinkedPerson, LinkedPersonEntity> {
}

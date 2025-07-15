package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.AssetPerYearEntity;
import com.sico.api.checkinline.domain.models.general.report.AssetPerYear;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetPerYearMapper extends EntityMapper<AssetPerYear, AssetPerYearEntity> {
}

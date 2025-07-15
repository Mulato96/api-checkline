package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.entities.NetSalesPerYearEntity;
import com.sico.api.checkinline.domain.models.general.report.NetSalesPerYear;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NetSalesPerYearMapper extends EntityMapper<NetSalesPerYear, NetSalesPerYearEntity> {
}

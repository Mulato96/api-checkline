package com.sico.api.checkinline.infraestructure.mappers.financialReport;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.sico.api.checkinline.domain.entities.FinancialReportEntity;
import com.sico.api.checkinline.domain.models.financialReport.FinancialReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinancialReportMapper extends EntityMapper<FinancialReport, FinancialReportEntity>{
    
}

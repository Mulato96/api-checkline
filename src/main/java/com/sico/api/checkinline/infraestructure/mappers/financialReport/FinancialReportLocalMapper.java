package com.sico.api.checkinline.infraestructure.mappers.financialReport;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.sico.api.checkinline.domain.entities.FinancialReportLocalEntity;
import com.sico.api.checkinline.domain.models.financialReport.FinancialReportLocal;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinancialReportLocalMapper extends EntityMapper<FinancialReportLocal, FinancialReportLocalEntity> {
    
}

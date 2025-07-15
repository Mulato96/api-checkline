package com.sico.api.checkinline.infraestructure.mappers.Proposers;

import com.sico.api.checkinline.domain.entities.ProposersReport.FinancialCapacityReportEntity;
import com.sico.api.checkinline.domain.models.Proposers.FinancialCapacityReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinancialCapacityReportMapper extends EntityMapper<FinancialCapacityReport, FinancialCapacityReportEntity> {
}

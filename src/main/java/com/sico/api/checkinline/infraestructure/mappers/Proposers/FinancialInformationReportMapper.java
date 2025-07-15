package com.sico.api.checkinline.infraestructure.mappers.Proposers;

import com.sico.api.checkinline.domain.entities.ProposersReport.FinancialInformationReportEntity;
import com.sico.api.checkinline.domain.models.Proposers.FinancialInformationReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinancialInformationReportMapper extends EntityMapper<FinancialInformationReport, FinancialInformationReportEntity> {
}

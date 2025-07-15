package com.sico.api.checkinline.infraestructure.mappers.Proposers;

import com.sico.api.checkinline.domain.entities.ProposersReport.GeneralDataReportEntity;
import com.sico.api.checkinline.domain.models.Proposers.GeneralDataReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GeneralDataReportMapper extends EntityMapper<GeneralDataReport, GeneralDataReportEntity> {
}

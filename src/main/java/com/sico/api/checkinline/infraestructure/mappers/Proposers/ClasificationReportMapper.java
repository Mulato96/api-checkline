package com.sico.api.checkinline.infraestructure.mappers.Proposers;

import com.sico.api.checkinline.domain.entities.ProposersReport.ClasificationReportEntity;
import com.sico.api.checkinline.domain.models.Proposers.ClasificationReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClasificationReportMapper extends EntityMapper<ClasificationReport, ClasificationReportEntity> {
}

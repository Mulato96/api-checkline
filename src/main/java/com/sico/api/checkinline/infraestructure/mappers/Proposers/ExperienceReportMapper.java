package com.sico.api.checkinline.infraestructure.mappers.Proposers;

import com.sico.api.checkinline.domain.entities.ProposersReport.ExperienceReportEntity;
import com.sico.api.checkinline.domain.models.Proposers.ExperienceReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExperienceReportMapper extends EntityMapper<ExperienceReport, ExperienceReportEntity> {
}

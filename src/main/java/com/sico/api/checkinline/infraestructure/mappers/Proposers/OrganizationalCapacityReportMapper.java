package com.sico.api.checkinline.infraestructure.mappers.Proposers;

import com.sico.api.checkinline.domain.entities.ProposersReport.OrganizationalCapacityReportEntity;
import com.sico.api.checkinline.domain.models.Proposers.OrganizationalCapacityReport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrganizationalCapacityReportMapper extends EntityMapper<OrganizationalCapacityReport, OrganizationalCapacityReportEntity> {
}

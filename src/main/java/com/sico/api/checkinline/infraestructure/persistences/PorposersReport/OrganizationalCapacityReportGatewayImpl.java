package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.models.Proposers.OrganizationalCapacityReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.OrganizationalCapacityReportGateway;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.OrganizationalCapacityReportMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrganizationalCapacityReportGatewayImpl implements OrganizationalCapacityReportGateway {

    private final JpaOrganizationalCapacityReportRepository repository;
    private final OrganizationalCapacityReportMapper mapper;

    @Override
    public OrganizationalCapacityReport consultOrganizationCapacity(String id) {
        return mapper.toDto(repository.consultOrganizationalCapacity(id));
    }
}

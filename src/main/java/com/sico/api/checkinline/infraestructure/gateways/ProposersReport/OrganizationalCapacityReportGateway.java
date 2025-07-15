package com.sico.api.checkinline.infraestructure.gateways.ProposersReport;

import com.sico.api.checkinline.domain.models.Proposers.OrganizationalCapacityReport;

public interface OrganizationalCapacityReportGateway {
    OrganizationalCapacityReport consultOrganizationCapacity(String id);
}

package com.sico.api.checkinline.infraestructure.gateways.ProposersReport;

import com.sico.api.checkinline.domain.models.Proposers.FinancialCapacityReport;

public interface FinancialCapacityReportGateway {
    FinancialCapacityReport consultFinancialCapacity(String id);
}

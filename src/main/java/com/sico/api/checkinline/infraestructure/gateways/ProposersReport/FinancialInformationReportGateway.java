package com.sico.api.checkinline.infraestructure.gateways.ProposersReport;

import com.sico.api.checkinline.domain.models.Proposers.FinancialInformationReport;

public interface FinancialInformationReportGateway {
     FinancialInformationReport consultFinancialInformation(String id);
}

package com.sico.api.checkinline.domain.usecases;

import java.util.List;

import com.sico.api.checkinline.domain.models.financialReport.FinancialReport;
import com.sico.api.checkinline.infraestructure.gateways.financialReport.FinancialReportGateway;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FinancialReportUseCase {

    private final FinancialReportGateway financialGateway;

    public List<FinancialReport> getFinancialReportList(boolean isBogota, String registrationNumber, Integer chamberId, String registered) {
        return financialGateway.getFinancialReportList(isBogota, registrationNumber, chamberId, registered);
    }
    
}

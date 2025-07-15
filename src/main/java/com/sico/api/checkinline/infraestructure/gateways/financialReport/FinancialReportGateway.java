package com.sico.api.checkinline.infraestructure.gateways.financialReport;

import java.util.List;

import com.sico.api.checkinline.domain.models.financialReport.FinancialReport;

public interface FinancialReportGateway {

    List<FinancialReport> getFinancialReportList(boolean isBogota, String registeredId, Integer chamberId, String registered);
    
}

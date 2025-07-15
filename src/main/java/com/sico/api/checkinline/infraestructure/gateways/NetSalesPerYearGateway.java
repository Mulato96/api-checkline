package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.NetSalesPerYear;

import java.util.List;

public interface NetSalesPerYearGateway {

  List<NetSalesPerYear> checkOutNetSalesPerYears(String companyId, Boolean isBogota);
}

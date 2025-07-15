package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.NetSalesPerYearGateway;
import com.sico.api.checkinline.domain.models.general.report.NetSalesPerYear;
import com.sico.api.checkinline.infraestructure.mappers.NetSalesPerYearMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NetSalesPerYearGatewayImpl implements NetSalesPerYearGateway {

  private final JpaNetSalesPerYearRepository repository;
  private final NetSalesPerYearMapper mapper;

  @Override
  public List<NetSalesPerYear> checkOutNetSalesPerYears(String companyId, Boolean isBogota) {
    return mapper.toDto(repository.checkOutNetSalesPerYears(companyId, isBogota));
  }
}

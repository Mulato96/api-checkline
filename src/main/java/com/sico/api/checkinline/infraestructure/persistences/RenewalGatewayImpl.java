package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.RenewalGateway;
import com.sico.api.checkinline.domain.models.general.report.Renewal;
import com.sico.api.checkinline.infraestructure.mappers.RenewalMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RenewalGatewayImpl implements RenewalGateway {

  private final JpaRenewalRepository repository;
  private final RenewalMapper mapper;
  @Override
  public List<Renewal> checkOutRenewals(String companyId) {
    return mapper.toDto(repository.checkOutRenewals(companyId));
  }
}

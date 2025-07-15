package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.ExecutiveGateway;
import com.sico.api.checkinline.domain.models.general.report.Executive;
import com.sico.api.checkinline.infraestructure.mappers.ExecutiveMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExecutiveGatewayImpl implements ExecutiveGateway {

  private final JpaExecutiveRepository repository;
  private final ExecutiveMapper mapper;

  @Override
  public List<Executive> checkOutExecutives(String companyId, Boolean isBogota) {
    return mapper.toDto(repository.checkOutExecutives(companyId, isBogota));
  }
}

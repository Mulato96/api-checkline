package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.CompanySizeGateway;
import com.sico.api.checkinline.domain.models.general.report.CompanySize;
import com.sico.api.checkinline.infraestructure.mappers.CompanySizeMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanySizeGatewayImpl implements CompanySizeGateway {

  private final JpaCompanySizeRepository repository;
  private final CompanySizeMapper mapper;

  @Override
  public List<CompanySize> checkOutCompanySizes(String companyId, Boolean isBogota) {
    return mapper.toDto(repository.checkOutCompanySizes(companyId, isBogota));
  }
}

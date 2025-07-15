package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.LegalRepresentativeGateway;
import com.sico.api.checkinline.domain.models.general.report.LegalRepresentative;
import com.sico.api.checkinline.infraestructure.mappers.LegalRepresentativeMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LegalRepresentativeGatewayImpl implements LegalRepresentativeGateway {

  private final JpaLegalRepresentativeRepository repository;
  private final LegalRepresentativeMapper mapper;

  @Override
  public List<LegalRepresentative> checkOutLegalRepresentatives(String companyId, Boolean isBogota) {
    return mapper.toDto(repository.checkOutLegalRepresentatives(companyId, isBogota));
  }
}

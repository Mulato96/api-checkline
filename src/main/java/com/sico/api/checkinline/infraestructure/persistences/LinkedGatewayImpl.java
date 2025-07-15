package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.LinkedGateway;
import com.sico.api.checkinline.domain.models.general.report.Linked;
import com.sico.api.checkinline.infraestructure.mappers.LinkedMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LinkedGatewayImpl implements LinkedGateway {

  private final JpaLinkedRepository repository;
  private final LinkedMapper mapper;

  @Override
  public List<Linked> checkOutLinkeds(String companyId, Boolean isBogota) {
    return mapper.toDto(repository.checkOutLinkeds(companyId, isBogota));
  }
}

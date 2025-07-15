package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.AssetPerYearGateway;
import com.sico.api.checkinline.domain.models.general.report.AssetPerYear;
import com.sico.api.checkinline.infraestructure.mappers.AssetPerYearMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AssetPerYearGatewayImpl implements AssetPerYearGateway {

  private final JpaAssetPerYearRepository repository;
  private final AssetPerYearMapper mapper;

  @Override
  public List<AssetPerYear> checkOutAssetsPerYears(String companyId, Boolean isBogota) {
    return mapper.toDto(repository.checkOutAssetsPerYears(companyId, isBogota));
  }
}

package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.AssetPerYear;

import java.util.List;

public interface AssetPerYearGateway {

  List<AssetPerYear> checkOutAssetsPerYears(String companyId, Boolean isBogota);
}

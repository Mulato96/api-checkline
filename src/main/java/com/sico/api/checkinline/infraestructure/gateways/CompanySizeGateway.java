package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.CompanySize;

import java.util.List;

public interface CompanySizeGateway {

  List<CompanySize> checkOutCompanySizes(String companyId, Boolean isBogota);
}

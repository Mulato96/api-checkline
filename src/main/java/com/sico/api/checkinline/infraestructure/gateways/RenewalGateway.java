package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.Renewal;

import java.util.List;

public interface RenewalGateway {

  List<Renewal> checkOutRenewals(String companyId);
}

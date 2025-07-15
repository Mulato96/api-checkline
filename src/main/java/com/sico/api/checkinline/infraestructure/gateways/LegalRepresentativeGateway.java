package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.LegalRepresentative;

import java.util.List;

public interface LegalRepresentativeGateway {

  List<LegalRepresentative> checkOutLegalRepresentatives(String companyId, Boolean isBogota);
}

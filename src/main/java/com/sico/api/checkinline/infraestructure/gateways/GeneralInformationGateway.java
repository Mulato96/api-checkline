package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.GeneralInformation;

public interface GeneralInformationGateway {

  GeneralInformation checkOutGeneralInformation(String companyId, Boolean isBogota);
}

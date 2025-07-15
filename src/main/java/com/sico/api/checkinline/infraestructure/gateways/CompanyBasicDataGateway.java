package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.CompanyBasicData;

public interface CompanyBasicDataGateway {
    CompanyBasicData getCompanyBasicData(Long registeredId, Long clientId);
    CompanyBasicData getCompanyBasicDataOC(String registeredId, Long commerceId);
}

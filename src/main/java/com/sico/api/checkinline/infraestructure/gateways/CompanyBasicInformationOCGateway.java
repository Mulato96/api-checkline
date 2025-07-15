package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;

public interface CompanyBasicInformationOCGateway {
    CompanyBasicInformationOC getInformationByIdentificationAndRegister(String identification, String register);
}

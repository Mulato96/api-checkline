package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;

public interface CompanyBasicInformationGateway {

    CompanyBasicInformation getInformationByCompanyId(Long companyId);
}

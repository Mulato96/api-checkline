package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.CompanyInformation;

public interface CompanyInformationGateway {
    CompanyInformation companyInformation(String companyId, String tuition);
}

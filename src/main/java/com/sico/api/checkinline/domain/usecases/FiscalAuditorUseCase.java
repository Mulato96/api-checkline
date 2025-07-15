package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.fiscalauditor.FiscalAuditor;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationGateway;
import com.sico.api.checkinline.infraestructure.gateways.fiscalauditor.FiscalAuditorGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FiscalAuditorUseCase {

    private final CompanyBasicInformationGateway companyBasicInformationGateway;
    private final FiscalAuditorGateway fiscalAuditorGateway;

    public List<FiscalAuditor> getFiscalAuditorData(Long companyId){
        CompanyBasicInformation informationByNit = companyBasicInformationGateway.getInformationByCompanyId(companyId);
        return fiscalAuditorGateway.getFiscalAuditorData(informationByNit.getCompanyId(), informationByNit.getRegisteredId());
    }
}

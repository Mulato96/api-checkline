package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;
import com.sico.api.checkinline.domain.models.general.report.GeneralInformation;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certifications;
import com.sico.api.checkinline.domain.models.legalrepresentation.LegalExistenceReport;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationGateway;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationOCGateway;
import com.sico.api.checkinline.infraestructure.gateways.GeneralInformationGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificasGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificationsGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.IdentificationGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LegalRepresentationUseCase {
    private final CertificasGateway certificasGateway;
    private final IdentificationGateway identificationGateway;
    private final CompanyBasicInformationGateway companyBasicInformationGateway;
    private final CertificationsGateway certificationsGateway;
    public LegalExistenceReport consultCertificas(String id, Boolean isBogota, String numMatricula) {
        Certifications certifications = certificationsGateway.consultCertifications(id);
        if (isBogota){
            CompanyBasicInformation basicInformation = companyBasicInformationGateway.getInformationByCompanyId(Long.parseLong(id));
            return LegalExistenceReport.builder()
                    .certificas(certificasGateway.consultCertificas(id))
                    .identificationSection(identificationGateway.getIdentificationSection(basicInformation.getRegisteredId(), Long.parseLong(id)))
                    .rup(certifications.getRup())
                    .build();
        }else{
            return LegalExistenceReport.builder()
                    .certificas(certificasGateway.consultCertificasOC(id , numMatricula))
                    .identificationSection(identificationGateway.getIdentificationSectionOC(numMatricula,Long.parseLong(id)))
                    .rup(certifications.getRup())
                    .build();
        }
    }
}

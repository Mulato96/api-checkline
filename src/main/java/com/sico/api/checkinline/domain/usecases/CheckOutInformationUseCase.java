package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.application.exceptions.BadRequestException;
import com.sico.api.checkinline.application.properties.AppProperties;
import com.sico.api.checkinline.domain.models.general.CompanyBasicData;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;
import com.sico.api.checkinline.domain.models.general.InformationReport;
import com.sico.api.checkinline.domain.models.general.report.CompanyInformation;
import com.sico.api.checkinline.domain.models.general.report.GeneralInformation;
import com.sico.api.checkinline.infraestructure.gateways.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

@RequiredArgsConstructor
public class CheckOutInformationUseCase {

    private final AppProperties properties;
    private final CompanyInformationGateway companyInformationGateway;
    private final GeneralInformationGateway generalInformationGateway;
    private final RenewalGateway renewalGateway;
    private final EmployeeGateway employeeGateway;
    private final LegalRepresentativeGateway legalRepresentativeGateway;
    private final LinkedGateway linkedGateway;
    private final ExecutiveGateway executiveGateway;
    private final AssociatedEstablishmentGateway associatedEstablishmentGateway;
    private final NetSalesPerYearGateway netSalesPerYearGateway;
    private final AssetPerYearGateway assetPerYearGateway;
    private final CompanySizeGateway companySizeGateway;
    private final MessageTranslator message;
    private final CompanyBasicDataGateway companyBasicDataGateway;
    private final CompanyBasicInformationGateway companyBasicInformationGateway;
    private final CompanyBasicInformationOCGateway companyBasicInformationOCGateway;
    private final FiscalAuditorUseCase fiscalAuditorUseCase;
    private final ProposerReportUseCase proposersUseCase;
    private final ImporterExporterUseCase importerExporterUseCase;

    public InformationReport checkOutInformationReport(String companyId, Boolean isBogota) {
        if (StringUtils.isNumeric(companyId) && Boolean.FALSE.equals(isBogota)) {
            throw new BadRequestException(message.getMessage("error.search.with.incorrect.parameters"));
        }
        return InformationReport.builder()
                .generalInformation(generalInformationGateway.checkOutGeneralInformation(companyId, isBogota))
                .hasProposer(!proposersUseCase.consultProposer((companyId)).isEmpty())
                .hasFiscalAuditor(isBogota && !fiscalAuditorUseCase.getFiscalAuditorData(Long.parseLong(companyId)).isEmpty())
                .hasImporterExporterData(Boolean.TRUE.equals(isBogota) ? importerExporterUseCase.consultImpoterExporter(companyId) : false)
                .renewals(Boolean.TRUE.equals(isBogota) ? renewalGateway.checkOutRenewals(companyId) : Collections.emptyList())
                .employees(employeeGateway.checkOutEmployees(companyId, isBogota, properties.getYears()))
                .legalRepresentatives(legalRepresentativeGateway
                        .checkOutLegalRepresentatives(companyId, isBogota))
                .linkeds(linkedGateway.checkOutLinkeds(companyId, isBogota))
                .executives(executiveGateway.checkOutExecutives(companyId, isBogota))
                .associatedEstablishments(associatedEstablishmentGateway
                        .checkOutAssociatedEstablishments(companyId, isBogota))
                .netSalesPerYears(netSalesPerYearGateway.checkOutNetSalesPerYears(companyId, isBogota))
                .assetPerYears(assetPerYearGateway.checkOutAssetsPerYears(companyId, isBogota))
                .companySizes(companySizeGateway.checkOutCompanySizes(companyId, isBogota))
                .build();
    }

    public InformationReport checkOutCompanyInformationReport(String documentNumber, String tuition) {
        CompanyInformation companyInformation = companyInformationGateway.companyInformation(documentNumber, tuition);
        if (companyInformation == null) {
            throw new BadRequestException(message.getMessage("error.search.with.incorrect.parameters"));
        }

        return checkOutInformationReport(companyInformation.getIdCompany(), companyInformation.getIsBogota());
    }

    public CompanyBasicData checkOutCompanyBasicData(String companyId, Boolean isBogota) {
        if (isBogota) {
            CompanyBasicInformation basicInformation = companyBasicInformationGateway.getInformationByCompanyId(Long.parseLong(companyId));
            return companyBasicDataGateway.getCompanyBasicData(basicInformation.getRegisteredId(), basicInformation.getCompanyId());
        } else {
            GeneralInformation generalInformation = generalInformationGateway.checkOutGeneralInformation(companyId, false);
            CompanyBasicInformationOC companyBasicInformationOC = companyBasicInformationOCGateway.getInformationByIdentificationAndRegister(generalInformation.getIdentification(), generalInformation.getRegister());
            return companyBasicDataGateway.getCompanyBasicDataOC(generalInformation.getRegister(), companyBasicInformationOC.getChamberId());
        }
    }

}

package com.sico.api.checkinline.application.configs;

import com.sico.api.checkinline.application.properties.VerificationLaftProperties;
import com.sico.api.checkinline.domain.port.driver.CheckDigit;
import com.sico.api.checkinline.domain.port.driver.IdentificationTypeGateway;
import com.sico.api.checkinline.domain.port.driver.laftverification.LaftVerificationGateway;
import com.sico.api.checkinline.domain.usecases.*;
import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.application.properties.AppProperties;
import com.sico.api.checkinline.domain.port.driver.CompanySearchGateway;
import com.sico.api.checkinline.domain.usecases.laft.GenerateLaftRequestUseCase;
import com.sico.api.checkinline.domain.usecases.laft.GetLinkedPersonUseCase;
import com.sico.api.checkinline.domain.usecases.naturalpersonregistration.NaturalPersonRegistrationUseCase;
import com.sico.api.checkinline.domain.usecases.laft.GetParametersVerificationLaftUseCase;
import com.sico.api.checkinline.domain.usecases.laft.ValidateVerificationLaftUseCase;
import com.sico.api.checkinline.infraestructure.gateways.*;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ExportGateway;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ImportGateway;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.*;
import com.sico.api.checkinline.infraestructure.gateways.financialReport.FinancialReportGateway;
import com.sico.api.checkinline.infraestructure.gateways.fiscalauditor.FiscalAuditorGateway;
import com.sico.api.checkinline.infraestructure.gateways.laft.LinkedPersonGateway;
import com.sico.api.checkinline.infraestructure.gateways.laft.LinkedPersonOCGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificasGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificationsGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.IdentificationGateway;
import com.sico.api.checkinline.infraestructure.gateways.linkedverification.LinkedVerificationGateway;
import com.sico.api.checkinline.infraestructure.gateways.naturalpersonregistration.NaturalPersonRegistrationGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class UseCaseConfig {

    @Bean
    public CheckOutInformationUseCase checkOutInformationUseCase(AppProperties properties,
            CompanyInformationGateway companyInformationGateway,
            GeneralInformationGateway generalInformationGateway,
            RenewalGateway renewalGateway,
            EmployeeGateway employeeGateway,
            LegalRepresentativeGateway legalRepresentativeGateway,
            LinkedGateway linkedGateway,
            ExecutiveGateway executiveGateway,
            AssociatedEstablishmentGateway associatedEstablishmentGateway,
            NetSalesPerYearGateway netSalesPerYearGateway,
            AssetPerYearGateway assetPerYearGateway,
            CompanySizeGateway companySizeGateway,
            MessageTranslator message,
            CompanyBasicDataGateway companyBasicDataGateway,
            CompanyBasicInformationGateway companyBasicInformationGateway,
            CompanyBasicInformationOCGateway companyBasicInformationOCGateway,
            FiscalAuditorUseCase fiscalAuditorUseCase,
            ProposerReportUseCase proposerUseCase,
            ImporterExporterUseCase importerExporterUseCase) {
        return new CheckOutInformationUseCase(properties, companyInformationGateway, generalInformationGateway,
                renewalGateway,
                employeeGateway, legalRepresentativeGateway, linkedGateway, executiveGateway,
                associatedEstablishmentGateway, netSalesPerYearGateway, assetPerYearGateway,
                companySizeGateway, message, companyBasicDataGateway, companyBasicInformationGateway,
                companyBasicInformationOCGateway, fiscalAuditorUseCase, proposerUseCase,importerExporterUseCase);
    }

    @Bean
    public CheckOutCompanySearchUseCase checkOutCompanySearchUseCase(CompanySearchGateway companySearchGateway) {
        return new CheckOutCompanySearchUseCase(companySearchGateway);
    }

    @Bean
    public FiscalAuditorUseCase fiscalAuditorUseCase(CompanyBasicInformationGateway companyBasicInformationGateway,
            FiscalAuditorGateway fiscalAuditorGateway) {
        return new FiscalAuditorUseCase(companyBasicInformationGateway, fiscalAuditorGateway);
    }

    @Bean
    public ProposerReportUseCase consultReportInformationUseCase(GeneralDataReportGateway generalDataReportGateway,
            FinancialInformationReportGateway financialInformationReportGateway,
            FinancialCapacityReportGateway financialCapacityReportGateway,
            OrganizationalCapacityReportGateway organizationalCapacityReportGateway,
            ClasificationReportGateway clasificationReportGateway,
            ExperienceReportGateway experienceReportGateway) {
        return new ProposerReportUseCase(generalDataReportGateway,
                financialInformationReportGateway,
                financialCapacityReportGateway,
                organizationalCapacityReportGateway,
                clasificationReportGateway,
                experienceReportGateway);

    }

    @Bean
    public LegalRepresentationUseCase legalRepresentationUseCase(CertificasGateway certificasGateway,
                                                                 IdentificationGateway identificationGateway,
                                                                 CompanyBasicInformationGateway companyBasicInformationGateway,
                                                                 CertificationsGateway certificationsGateway) {
        return new LegalRepresentationUseCase(certificasGateway, identificationGateway, companyBasicInformationGateway, certificationsGateway);
    }

    @Bean
    public ImporterExporterUseCase importerExporterUseCase(ImportGateway importerExporterGateway,
            ExportGateway exporterGateway) {
        return new ImporterExporterUseCase(importerExporterGateway, exporterGateway);
    }

    @Bean
    public GetLinkedPersonUseCase getLinkedPersonUseCase(LinkedPersonGateway linkedPersonGateway,
            LinkedPersonOCGateway linkedPersonOCGateway,
            GeneralInformationGateway generalInformationGateway,
            CompanyBasicInformationOCGateway companyBasicInformationOCGateway) {
        return new GetLinkedPersonUseCase(linkedPersonGateway, linkedPersonOCGateway, generalInformationGateway,
                companyBasicInformationOCGateway);
    }

    @Bean
    public LinkedVerificationUseCase linkedVerificationUseCase(LinkedVerificationGateway linkedVerificationGateway) {
        return new LinkedVerificationUseCase(linkedVerificationGateway);
    }

    @Bean
    public FinancialReportUseCase financialReportUseCase(FinancialReportGateway financialReportGateway) {
        return new FinancialReportUseCase(financialReportGateway);
    }

    @Bean
    public NaturalPersonRegistrationUseCase naturalPersonRegistrationUseCase(NaturalPersonRegistrationGateway naturalPersonRegistrationGateway) {
        return new NaturalPersonRegistrationUseCase(naturalPersonRegistrationGateway);
    }


    @Bean
    public ValidateVerificationLaftUseCase validateVerificationLaftUseCase(
            VerificationLaftProperties verificationLaftProperties,
            MessageTranslator messageTranslator,
            IdentificationTypeGateway identificationTypeGateway) {
        return new ValidateVerificationLaftUseCase(verificationLaftProperties, messageTranslator,
                identificationTypeGateway);
    }

    @Bean
    public GetParametersVerificationLaftUseCase getParametersVerificationLaftUseCase(
        VerificationLaftProperties verificationLaftProperties) {
        return new GetParametersVerificationLaftUseCase(verificationLaftProperties);
    }

    @Bean
    public GenerateLaftRequestUseCase generateLaftRequestUseCase(
        LaftVerificationGateway laftVerificationGateway){
        return new GenerateLaftRequestUseCase(laftVerificationGateway);
    }

    public UseCaseConfig() {
        log.info("..::Starting Use Cases Configuration::..");
    }
}

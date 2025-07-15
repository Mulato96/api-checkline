package com.sico.api.checkinline.application.configs;

import com.sico.api.checkinline.domain.entities.*;
import com.sico.api.checkinline.domain.entities.ProposersReport.*;
import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificasEntity;
import com.sico.api.checkinline.domain.entities.legalrepresentation.IdentificationEntity;
import com.sico.api.checkinline.domain.entities.linkedverification.LinkedVerificationEntity;
import com.sico.api.checkinline.domain.port.driver.CompanySearchGateway;
import com.sico.api.checkinline.domain.port.driver.IdentificationTypeGateway;
import com.sico.api.checkinline.infraestructure.builder.ExcelBuilder;
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
import com.sico.api.checkinline.infraestructure.mappers.*;
import com.sico.api.checkinline.infraestructure.mappers.ImporterExporter.ImportExportMapper;
import com.sico.api.checkinline.infraestructure.mappers.fiscalauditor.FiscalAuditorMapper;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.*;
import com.sico.api.checkinline.infraestructure.mappers.laft.LinkedPersonMapper;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.CertificasMapper;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.CertificationsMapper;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.IdentificationMapper;
import com.sico.api.checkinline.infraestructure.mappers.linkedverification.LinkedVerificationMapper;
import com.sico.api.checkinline.infraestructure.mappers.naturalpersonregistration.NaturalPersonRegistrationMapper;
import com.sico.api.checkinline.infraestructure.external.rest.LaftVerificationGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.*;
import com.sico.api.checkinline.infraestructure.persistences.ImporterExporter.ExportGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.ImporterExporter.ImportGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.ImporterExporter.JpaExportRepository;
import com.sico.api.checkinline.infraestructure.persistences.ImporterExporter.JpaImportRepository;
import com.sico.api.checkinline.infraestructure.persistences.fiscalauditor.FiscalAuditorGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.fiscalauditor.JpaFiscalAuditorRepository;
import com.sico.api.checkinline.infraestructure.persistences.PorposersReport.*;
import com.sico.api.checkinline.infraestructure.persistences.financialReport.FinancialReportGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.financialReport.FinancialReportLocalRepository;
import com.sico.api.checkinline.infraestructure.persistences.financialReport.FinancialReportRepository;
import com.sico.api.checkinline.infraestructure.persistences.laft.JpaLinkedPersonOCRepository;
import com.sico.api.checkinline.infraestructure.persistences.laft.JpaLinkedPersonRepository;
import com.sico.api.checkinline.infraestructure.persistences.laft.LinkedPersonGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.laft.LinkedPersonOCGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.legalrepresentation.*;
import com.sico.api.checkinline.infraestructure.persistences.linkedverification.LinkedVerificationGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.linkedverification.LinkedVerificationRepository;
import com.sico.api.checkinline.infraestructure.persistences.naturalpersonregistration.NaturalPersonRegistrationGatewayImpl;
import com.sico.api.checkinline.infraestructure.persistences.naturalpersonregistration.NaturalPersonRegistrationRepository;
import com.sico.api.checkinline.infraestructure.utils.CheckDigitImpl;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan(basePackageClasses = {
        CompanyInformationGatewayImpl.class,
        GeneralInformationGatewayImpl.class,
        RenewalGatewayImpl.class,
        EmployeeGatewayImpl.class,
        LegalRepresentativeGatewayImpl.class,
        LinkedGatewayImpl.class,
        ExecutiveGatewayImpl.class,
        AssociatedEstablishmentGatewayImpl.class,
        NetSalesPerYearGatewayImpl.class,
        AssetPerYearGatewayImpl.class,
        CompanySizeGatewayImpl.class,
        CompanySearchGatewayImpl.class,
        CheckDigitImpl.class,
        GeneralDataReportGatewayImpl.class,
        FinancialInformationReportGatewayImpl.class,
        FinancialCapacityReportGatewayImpl.class,
        OrganizationalCapacityReportGatewayImpl.class,
        ClasificationReportGatewayImpl.class,
        ExperienceReportGatewayImpl.class,
        CertificasGatewayImpl.class,
        IdentificationGatewayImpl.class,
        FinancialReportGatewayImpl.class,
        LaftVerificationGatewayImpl.class
})
@EnableJpaRepositories(basePackageClasses = {
        JpaCompanyInformationRepository.class,
        JpaGeneralInformationRepository.class,
        JpaRenewalRepository.class,
        JpaEmployeeRepository.class,
        JpaLegalRepresentativeRepository.class,
        JpaLinkedRepository.class,
        JpaExecutiveRepository.class,
        JpaAssociatedEstablishmentRepository.class,
        JpaNetSalesPerYearRepository.class,
        JpaAssetPerYearRepository.class,
        JpaCompanySizeRepository.class,
        JpaCompanySearchRepository.class,
        JpaGeneralDataReportRepository.class,
        JpaFinancialInformationReportRepository.class,
        JpaFinancialCapacityReportRepository.class,
        JpaOrganizationalCapacityReportRepository.class,
        JpaClasificationReportRepository.class,
        JpaExperienceReportRepository.class,
        JpaCertificasRepository.class,
        JpaCertificasRepository.class,
        LinkedVerificationRepository.class,
        FinancialReportLocalRepository.class,
        FinancialReportRepository.class,
        ReferenceClientRepository.class
})
@EntityScan(basePackageClasses = {
        CompanyInformationEntity.class,
        GeneralInformationEntity.class,
        RenewalEntity.class,
        EmployeeEntity.class,
        LegalRepresentativeEntity.class,
        LinkedEntity.class,
        ExecutiveEntity.class,
        AssociatedEstablishmentEntity.class,
        NetSalesPerYearEntity.class,
        AssetPerYearEntity.class,
        CompanySizeEntity.class,
        CompanySearchEntity.class,
        GeneralDataReportEntity.class,
        FinancialInformationReportEntity.class,
        FinancialCapacityReportEntity.class,
        OrganizationalCapacityReportEntity.class,
        ClasificationReportEntity.class,
        ExperienceReportEntity.class,
        CertificasEntity.class,
        IdentificationEntity.class,
        LinkedVerificationEntity.class,
        FinancialReportLocalEntity.class,
        FinancialReportEntity.class,
        ReferenceEntity.class
})
@Log4j2
public class JpaRepositoryConfig {

    @Bean
    public CompanySizeMapper companySizeMapper() {
        return Mappers.getMapper(CompanySizeMapper.class);
    }

    @Bean
    public CompanySizeGateway companySizeGateway(JpaCompanySizeRepository repository,
            CompanySizeMapper mapper) {
        return new CompanySizeGatewayImpl(repository, mapper);
    }

    @Bean
    public AssetPerYearMapper assetPerYearMapper() {
        return Mappers.getMapper(AssetPerYearMapper.class);
    }

    @Bean
    public AssetPerYearGateway assetPerYearGateway(JpaAssetPerYearRepository repository,
            AssetPerYearMapper mapper) {
        return new AssetPerYearGatewayImpl(repository, mapper);
    }

    @Bean
    public NetSalesPerYearMapper netSalesPerYearMapper() {
        return Mappers.getMapper(NetSalesPerYearMapper.class);
    }

    @Bean
    public NetSalesPerYearGateway netSalesPerYearGateway(JpaNetSalesPerYearRepository repository,
            NetSalesPerYearMapper mapper) {
        return new NetSalesPerYearGatewayImpl(repository, mapper);
    }

    @Bean
    public AssociatedEstablishmentMapper associatedEstablishmentMapper() {
        return Mappers.getMapper(AssociatedEstablishmentMapper.class);
    }

    @Bean
    public AssociatedEstablishmentGateway associatedEstablishmentGateway(
            JpaAssociatedEstablishmentRepository repository,
            AssociatedEstablishmentMapper mapper) {
        return new AssociatedEstablishmentGatewayImpl(repository, mapper);
    }

    @Bean
    public ExecutiveMapper executiveMapper() {
        return Mappers.getMapper(ExecutiveMapper.class);
    }

    @Bean
    public ExecutiveGateway executiveGateway(JpaExecutiveRepository repository,
            ExecutiveMapper mapper) {
        return new ExecutiveGatewayImpl(repository, mapper);
    }

    @Bean
    public LinkedMapper linkedMapper() {
        return Mappers.getMapper(LinkedMapper.class);
    }

    @Bean
    public LinkedGateway linkedGateway(JpaLinkedRepository repository, LinkedMapper mapper) {
        return new LinkedGatewayImpl(repository, mapper);
    }

    @Bean
    public LegalRepresentativeMapper legalRepresentativeMapper() {
        return Mappers.getMapper(LegalRepresentativeMapper.class);
    }

    @Bean
    public LegalRepresentativeGateway legalRepresentativeGateway(JpaLegalRepresentativeRepository repository,
            LegalRepresentativeMapper mapper) {
        return new LegalRepresentativeGatewayImpl(repository, mapper);
    }

    @Bean
    public EmployeeMapper employeeMapper() {
        return Mappers.getMapper(EmployeeMapper.class);
    }

    @Bean
    public EmployeeGateway employeeGateway(JpaEmployeeRepository repository, EmployeeMapper mapper) {
        return new EmployeeGatewayImpl(repository, mapper);
    }

    @Bean
    public RenewalMapper renewalMapper() {
        return Mappers.getMapper(RenewalMapper.class);
    }

    @Bean
    public RenewalGateway renewalGateway(JpaRenewalRepository repository, RenewalMapper mapper) {
        return new RenewalGatewayImpl(repository, mapper);
    }

    @Bean
    public CompanyInformationMapper companyInformationMapper() {
        return Mappers.getMapper(CompanyInformationMapper.class);
    }

    @Bean
    public CompanyInformationGateway companyInformationGateway(JpaCompanyInformationRepository repository,
            CompanyInformationMapper mapper) {
        return new CompanyInformationGatewayImpl(repository, mapper);
    }

    @Bean
    public GeneralInformationMapper generalInformationMapper() {
        return Mappers.getMapper(GeneralInformationMapper.class);
    }

    @Bean
    public GeneralInformationGateway generalInformationGateway(
        JpaGeneralInformationRepository repository,
        GeneralInformationMapper mapper, ReferenceClientRepository referenceClientRepository,
        ReferenceMapper referenceMapper) {
        return new GeneralInformationGatewayImpl(repository, mapper, referenceMapper,
            referenceClientRepository);
    }

    @Bean
    public CompanySearchMapper companySearchMapper() {
        return Mappers.getMapper((CompanySearchMapper.class));
    }

    @Bean
    public CompanySearchFilterMapper companySearchFilterMapper() {
        return Mappers.getMapper((CompanySearchFilterMapper.class));
    }

    @Bean
    public ReferenceMapper referenceMapper() {
        return Mappers.getMapper((ReferenceMapper.class));
    }

    @Bean
    public CompanySearchGateway companySearchGateway(JpaCompanySearchRepository repository,
            CompanySearchMapper mapper) {
        return new CompanySearchGatewayImpl(repository, mapper);

    }

    // Proposers Report
    @Bean
    public GeneralDataReportMapper proposersReportMapper() {
        return Mappers.getMapper(GeneralDataReportMapper.class);
    }

    @Bean
    public GeneralDataReportGateway generalDataReportGateway(JpaGeneralDataReportRepository repository,
            GeneralDataReportMapper mapper) {
        return new GeneralDataReportGatewayImpl(repository, mapper);
    }

    @Bean
    public FinancialInformationReportMapper financialInformationReportMapper() {
        return Mappers.getMapper(FinancialInformationReportMapper.class);
    }

    @Bean
    public FinancialInformationReportGateway financialInformationReportGateway(
            JpaFinancialInformationReportRepository repository,
            FinancialInformationReportMapper mapper) {
        return new FinancialInformationReportGatewayImpl(repository, mapper);
    }

    @Bean
    public FinancialCapacityReportMapper financialCapacityReportMapper() {
        return Mappers.getMapper(FinancialCapacityReportMapper.class);
    }

    @Bean
    public FinancialCapacityReportGateway financialCapacityReportGateway(
            JpaFinancialCapacityReportRepository repository,
            FinancialCapacityReportMapper mapper) {
        return new FinancialCapacityReportGatewayImpl(repository, mapper);
    }

    @Bean
    public OrganizationalCapacityReportMapper organizationalCapacityReportMapper() {
        return Mappers.getMapper(OrganizationalCapacityReportMapper.class);
    }

    @Bean
    public OrganizationalCapacityReportGateway organizationalCapacityReportGateway(
            JpaOrganizationalCapacityReportRepository repository,
            OrganizationalCapacityReportMapper mapper) {
        return new OrganizationalCapacityReportGatewayImpl(repository, mapper);
    }

    @Bean
    public ClasificationReportMapper clasificationReportMapper() {
        return Mappers.getMapper(ClasificationReportMapper.class);
    }

    @Bean
    public ClasificationReportGateway clasificationReportGateway(JpaClasificationReportRepository repository,
            ClasificationReportMapper mapper) {
        return new ClasificationReportGatewayImpl(repository, mapper);
    }

    @Bean
    public ExperienceReportMapper experienceReportMapper() {
        return Mappers.getMapper(ExperienceReportMapper.class);
    }

    @Bean
    public ExperienceReportGateway experienceReportGateway(JpaExperienceReportRepository repository,
            ExperienceReportMapper mapper) {
        return new ExperienceReportGatewayImpl(repository, mapper);
    }

    @Bean
    public CompanyBasicDataMapper companyBasicDataMapper() {
        return Mappers.getMapper((CompanyBasicDataMapper.class));
    }

    @Bean
    public CompanyBasicDataGateway companyBasicDataGateway(JpaCompanyBasicDataRepository repository,
            CompanyBasicDataMapper mapper) {
        return new CompanyBasicDataGatewayImpl(repository, mapper);
    }

    @Bean
    public CompanyBasicInformationMapper companyBasicInformationMapper() {
        return Mappers.getMapper((CompanyBasicInformationMapper.class));
    }

    @Bean
    public CompanyBasicInformationGateway companyBasicInformationGateway(
            JpaCompanyBasicInformationRepository repository,
            CompanyBasicInformationMapper mapper) {
        return new CompanyBasicInformationGatewayImpl(repository, mapper);
    }

    @Bean
    public CompanyBasicInformationOCMapper companyBasicInformationOCMapper() {
        return Mappers.getMapper((CompanyBasicInformationOCMapper.class));
    }

    @Bean
    public CompanyBasicInformationOCGateway companyBasicInformationOCGateway(
            JpaCompanyBasicInformationOCRepository repository,
            CompanyBasicInformationOCMapper mapper) {
        return new CompanyBasicInformationOCGatewayImpl(repository, mapper);
    }

    @Bean
    public FiscalAuditorMapper fiscalAuditorMapper() {
        return Mappers.getMapper((FiscalAuditorMapper.class));
    }

    @Bean
    public FiscalAuditorGateway fiscalAuditorGateway(JpaFiscalAuditorRepository repository,
            FiscalAuditorMapper mapper) {
        return new FiscalAuditorGatewayImpl(repository, mapper);
    }

    @Bean
    public CertificasMapper certificasMapper() {
        return Mappers.getMapper((CertificasMapper.class));
    }

    @Bean
    public CertificasGateway certificasGateway(JpaCertificasRepository repository,
            CertificasMapper mapper) {
        return new CertificasGatewayImpl(repository, mapper);
    }

    @Bean
    public ImportExportMapper importExportMapper() {
        return Mappers.getMapper(ImportExportMapper.class);
    }

    @Bean
    public ImportGateway importGateway(JpaImportRepository repository,
            ImportExportMapper mapper) {
        return new ImportGatewayImpl(repository, mapper);
    }

    @Bean
    public ExportGateway exportGateway(JpaExportRepository repository, ImportExportMapper mapper) {
        return new ExportGatewayImpl(repository, mapper);
    }

    @Bean
    public LinkedPersonMapper linkedPersonMapper() {
        return Mappers.getMapper((LinkedPersonMapper.class));
    }

    @Bean
    public LinkedPersonGateway linkedPersonGateway(JpaLinkedPersonRepository repository,
            LinkedPersonMapper mapper) {
        return new LinkedPersonGatewayImpl(repository, mapper);
    }

    @Bean
    public LinkedPersonOCGateway linkedPersonOCGateway(JpaLinkedPersonOCRepository repository,
            LinkedPersonMapper mapper) {
        return new LinkedPersonOCGatewayImpl(repository, mapper);
    }

    @Bean
    public IdentificationMapper identificationMapper(){return Mappers.getMapper((IdentificationMapper.class));}

    @Bean
    public IdentificationGateway identificationGateway(JpaIdentificationRepository repository,
                                                       IdentificationMapper mapper){
        return new IdentificationGatewayImpl(repository, mapper);
    }

    @Bean
    public LinkedVerificationMapper linkedVerificationMapper() {
        return Mappers.getMapper(LinkedVerificationMapper.class);
    }

    @Bean
    public LinkedVerificationGateway linkedVerificationGateway(LinkedVerificationRepository repository,
                                                               LinkedVerificationMapper mapper){
        return new LinkedVerificationGatewayImpl(repository, mapper);
    }

    @Bean
    public FinancialReportGateway financialReportGateway(FinancialReportLocalRepository repositoryLocal, FinancialReportRepository repository){
        return new FinancialReportGatewayImpl(repositoryLocal, repository);
    }

    @Bean
    public IdentificationTypeMapper identificationTypeMapper(){
        return Mappers.getMapper(IdentificationTypeMapper.class);
    }

    @Bean
    public IdentificationTypeGateway identificationTypeGateway(
        JpaIdentificationTypeRepository repository, IdentificationTypeMapper identificationMapper) {
        return new IdentificationTypeGatewayImpl(repository, identificationMapper);
    }

    @Bean
    public ExcelBuilder excelBuilder(){
        return new ExcelBuilder();
    }

    @Bean
    public NaturalPersonRegistrationMapper naturalPersonRegistrationMapper() {
        return Mappers.getMapper(NaturalPersonRegistrationMapper.class);
    }

    @Bean
    public NaturalPersonRegistrationGateway naturalPersonRegistrationGateway(NaturalPersonRegistrationRepository repository,
                                                                             NaturalPersonRegistrationMapper mapper){
        return new NaturalPersonRegistrationGatewayImpl(repository, mapper);
    }

    @Bean
    public CertificationsMapper certificationsMapper(){
        return Mappers.getMapper((CertificationsMapper.class));
    }

    @Bean
    public CertificationsGateway certificationsGateway (JpaCertificationsRepository repository,
                                                        CertificationsMapper mapper){
        return new CertificationsGatewayImpl(repository, mapper);
    }

    public JpaRepositoryConfig() {
        log.info("..::Starting Jpa Repositories Configuration::..");
    }
}

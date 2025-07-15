package com.sico.api.checkonline.domain.usecases;

import com.sico.api.checkinline.application.properties.AppProperties;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.domain.models.general.CompanyBasicData;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;
import com.sico.api.checkinline.domain.models.general.InformationReport;
import com.sico.api.checkinline.domain.models.general.report.*;
import com.sico.api.checkinline.domain.usecases.CheckOutInformationUseCase;
import com.sico.api.checkinline.domain.usecases.FiscalAuditorUseCase;
import com.sico.api.checkinline.domain.usecases.ImporterExporterUseCase;
import com.sico.api.checkinline.domain.usecases.ProposerReportUseCase;
import com.sico.api.checkinline.infraestructure.gateways.*;
import com.sico.api.testdatabuilder.CompanyInformationDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CheckOutInformationUseCaseTest {
    @Mock
    private AppProperties properties;

    @Mock
    private CompanyInformationGateway companyInformationGateway;

    @Mock
    private GeneralInformationGateway generalInformationGateway;

    @Mock
    private RenewalGateway renewalGateway;

    @Mock
    private EmployeeGateway employeeGateway;

    @Mock
    private LegalRepresentativeGateway legalRepresentativeGateway;

    @Mock
    private LinkedGateway linkedGateway;

    @Mock
    private ExecutiveGateway executiveGateway;

    @Mock
    private AssociatedEstablishmentGateway associatedEstablishmentGateway;

    @Mock
    private NetSalesPerYearGateway netSalesPerYearGateway;

    @Mock
    private AssetPerYearGateway assetPerYearGateway;

    @Mock
    private CompanySizeGateway companySizeGateway;

    @Mock
    private CompanyBasicDataGateway companyBasicDataGateway;

    @Mock
    private CompanyBasicInformationGateway companyBasicInformationGateway;

    @Mock
    private CompanyBasicInformationOCGateway companyBasicInformationOCGateway;

    @Mock
    private FiscalAuditorUseCase fiscalAuditorUseCase;

    @Mock
    private ProposerReportUseCase proposerUseCase;
    @Mock
    ImporterExporterUseCase importerExporterUseCase;

    @InjectMocks
    private CheckOutInformationUseCase checkOutInformationUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCheckOutInformationReport() {
        String companyId = "123";
        Boolean isBogota = true;

        when(properties.getYears()).thenReturn(5);
        GeneralInformation generalInformation = null;
        List<Renewal> renewals = null;
        List<Employee> employees = null;
        List<LegalRepresentative> legalRepresentative = null;
        List<Linked> linked = null;
        List<Executive> executives = null;
        List<AssociatedEstablishment> associatedEstablishments = null;
        List<NetSalesPerYear> netSalesPerYears = null;
        List<AssetPerYear> assetPerYears = null;
        List<CompanySize> companySizes = null;
        List<ImportExport> Imports =null;
        List<ImportExport> Exports= null;

        when(generalInformationGateway.checkOutGeneralInformation(companyId, isBogota)).thenReturn(generalInformation);
        when(renewalGateway.checkOutRenewals(companyId)).thenReturn(renewals);
        when(employeeGateway.checkOutEmployees(companyId, isBogota, properties.getYears())).thenReturn(employees);
        when(legalRepresentativeGateway.checkOutLegalRepresentatives(companyId, isBogota)).thenReturn(legalRepresentative);
        when(linkedGateway.checkOutLinkeds(companyId, isBogota)).thenReturn(linked);
        when(executiveGateway.checkOutExecutives(companyId, isBogota)).thenReturn(executives);
        when(associatedEstablishmentGateway.checkOutAssociatedEstablishments(companyId, isBogota)).thenReturn(associatedEstablishments);
        when(netSalesPerYearGateway.checkOutNetSalesPerYears(companyId, isBogota)).thenReturn(netSalesPerYears);
        when(assetPerYearGateway.checkOutAssetsPerYears(companyId, isBogota)).thenReturn(assetPerYears);
        when(companySizeGateway.checkOutCompanySizes(companyId, isBogota)).thenReturn(companySizes);
        InformationReport result = checkOutInformationUseCase.checkOutInformationReport(companyId, isBogota);


        verify(generalInformationGateway, times(1)).checkOutGeneralInformation(companyId, isBogota);
        verify(renewalGateway, times(1)).checkOutRenewals(companyId);
        verify(employeeGateway, times(1)).checkOutEmployees(companyId, isBogota, properties.getYears());
        verify(legalRepresentativeGateway, times(1)).checkOutLegalRepresentatives(companyId, isBogota);
        verify(linkedGateway, times(1)).checkOutLinkeds(companyId, isBogota);
        verify(executiveGateway, times(1)).checkOutExecutives(companyId, isBogota);
        verify(associatedEstablishmentGateway, times(1)).checkOutAssociatedEstablishments(companyId, isBogota);
        verify(netSalesPerYearGateway, times(1)).checkOutNetSalesPerYears(companyId, isBogota);
        verify(assetPerYearGateway, times(1)).checkOutAssetsPerYears(companyId, isBogota);
        verify(companySizeGateway, times(1)).checkOutCompanySizes(companyId, isBogota);

        assertNotNull(result);
    }

    @Test
    public void testCheckOutCompanyInformationReport() {
        CompanyInformation expectedCompanyInformation = CompanyInformationDataBuilder.aCompanyInformation()
                .withIdCompany("123")
                .withIsBogota(true)
                .build();

        when(companyInformationGateway.companyInformation("123", "123")).thenReturn(expectedCompanyInformation);
        InformationReport result = checkOutInformationUseCase.checkOutCompanyInformationReport("123", "123");
        verify(companyInformationGateway).companyInformation("123", "123");
    }

    @Test
    public void testCheckOutCompanyBasicData() {
        String companyId = "123";
        boolean isBogota = true;
        CompanyBasicInformation companyBasicInformation = new CompanyBasicInformation();
        companyBasicInformation.setRegisteredId(12345L);
        companyBasicInformation.setCompanyId(2345L);

        CompanyBasicData expectedCompanyBasicData = CompanyBasicData.builder()
                .idNumber("idNumber")
                .register("register")
                .registerStatus("registerStatus")
                .category("category")
                .commerceChamber("commerceChamber")
                .ciiu("ciiu")
                .economicActivity("economicActivity")
                .organizationType("organizationType")
                .companyName("companyName")
                .cancellationDate(LocalDate.now())
                .idType("idType")
                .registerDate(LocalDate.now())
                .address("address")
                .renewalDate(LocalDate.now())
                .municipality("municipality")
                .build();

        when(companyBasicInformationGateway.getInformationByCompanyId(123L))
                .thenReturn(companyBasicInformation);
        when(companyBasicDataGateway.getCompanyBasicData(12345L, 2345L)).thenReturn(expectedCompanyBasicData);

        CompanyBasicData result = checkOutInformationUseCase.checkOutCompanyBasicData(companyId, isBogota);

        assertNotNull(result);
        assertEquals("idNumber", result.getIdNumber());
        assertEquals("register", result.getRegister());
        assertEquals("registerStatus", result.getRegisterStatus());
        assertEquals("category", result.getCategory());
        assertEquals("commerceChamber", result.getCommerceChamber());
        assertEquals("ciiu", result.getCiiu());
        assertEquals("economicActivity", result.getEconomicActivity());
        assertEquals("organizationType", result.getOrganizationType());
        assertEquals("companyName", result.getCompanyName());
        assertEquals(LocalDate.now(), result.getCancellationDate());
        assertEquals("idType", result.getIdType());
        assertEquals(LocalDate.now(), result.getRegisterDate());
        assertEquals("address", result.getAddress());
        assertEquals(LocalDate.now(), result.getRenewalDate());
        assertEquals("municipality", result.getMunicipality());

        verify(companyBasicInformationGateway, times(1)).getInformationByCompanyId(123L);
        verify(companyBasicDataGateway, times(1)).getCompanyBasicData(12345L, 2345L);
    }

    @Test
    public void testCheckOutCompanyBasicDataNoBogota() {
        String companyId = "123";
        boolean isBogota = false;
        GeneralInformation generalInformation = new GeneralInformation();
        generalInformation.setRegister("12345");
        generalInformation.setCompanyId("2345");
        generalInformation.setIdentification("identification");

        CompanyBasicInformationOC companyBasicInformationOC = new CompanyBasicInformationOC();
        companyBasicInformationOC.setChamberId(12L);

        CompanyBasicData expectedCompanyBasicData = CompanyBasicData.builder()
                .idNumber("idNumber")
                .register("register")
                .registerStatus("registerStatus")
                .category("category")
                .commerceChamber("commerceChamber")
                .ciiu("ciiu")
                .economicActivity("economicActivity")
                .organizationType("organizationType")
                .companyName("companyName")
                .cancellationDate(LocalDate.now())
                .idType("idType")
                .registerDate(LocalDate.now())
                .address("address")
                .renewalDate(LocalDate.now())
                .municipality("municipality")
                .build();

        when(generalInformationGateway.checkOutGeneralInformation(companyId, isBogota))
                .thenReturn(generalInformation);
        when(companyBasicInformationOCGateway.getInformationByIdentificationAndRegister("identification", "12345"))
                .thenReturn(companyBasicInformationOC);
        when(companyBasicDataGateway.getCompanyBasicDataOC("12345", 12L))
                .thenReturn(expectedCompanyBasicData);

        CompanyBasicData result = checkOutInformationUseCase.checkOutCompanyBasicData(companyId, isBogota);

        assertNotNull(result);
        assertEquals("idNumber", result.getIdNumber());
        assertEquals("register", result.getRegister());
        assertEquals("registerStatus", result.getRegisterStatus());
        assertEquals("category", result.getCategory());
        assertEquals("commerceChamber", result.getCommerceChamber());
        assertEquals("ciiu", result.getCiiu());
        assertEquals("economicActivity", result.getEconomicActivity());
        assertEquals("organizationType", result.getOrganizationType());
        assertEquals("companyName", result.getCompanyName());
        assertEquals(LocalDate.now(), result.getCancellationDate());
        assertEquals("idType", result.getIdType());
        assertEquals(LocalDate.now(), result.getRegisterDate());
        assertEquals("address", result.getAddress());
        assertEquals(LocalDate.now(), result.getRenewalDate());
        assertEquals("municipality", result.getMunicipality());

        verify(generalInformationGateway, times(1)).checkOutGeneralInformation(companyId, isBogota);
        verify(companyBasicInformationOCGateway, times(1))
                .getInformationByIdentificationAndRegister("identification", "12345");
        verify(companyBasicDataGateway, times(1)).getCompanyBasicDataOC("12345", 12L);
    }
}

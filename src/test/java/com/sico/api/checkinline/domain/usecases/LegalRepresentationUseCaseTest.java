package com.sico.api.checkinline.domain.usecases;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certifications;
import com.sico.api.checkinline.domain.models.legalrepresentation.Identification;
import com.sico.api.checkinline.domain.models.legalrepresentation.LegalExistenceReport;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificasGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificationsGateway;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.IdentificationGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;



public class LegalRepresentationUseCaseTest {

    @Mock
    private CertificasGateway certificasGateway;

    @Mock
    private IdentificationGateway identificationGateway;

    @Mock
    CompanyBasicInformationGateway companyBasicInformationGateway;

    @Mock
    CertificationsGateway certificationsGateway;

    @InjectMocks
    private LegalRepresentationUseCase legalRepresentationUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultCertificas_Bogota() {

        String id = "123";
        Boolean isBogota = true;
        String numMatricula= "21231";
        Certificas certifica = new Certificas();
        List<Certificas> certificas = Collections.singletonList(certifica);
        Certifications certifications = new Certifications();
        Identification identification = new Identification();
        CompanyBasicInformation basicInformation = new CompanyBasicInformation();
        basicInformation.setRegisteredId(12345L);
        basicInformation.setCompanyId(2345L);

        when(certificationsGateway.consultCertifications(id)).thenReturn(certifications);
        when(companyBasicInformationGateway.getInformationByCompanyId(Long.parseLong(id))).thenReturn(basicInformation);
        when(certificasGateway.consultCertificas(id)).thenReturn(certificas);
        when(certificasGateway.consultCertificasOC(id, numMatricula)).thenReturn(certificas);
        when(identificationGateway.getIdentificationSection(basicInformation.getRegisteredId(), Long.parseLong(id))).thenReturn(identification);

        LegalExistenceReport result = legalRepresentationUseCase.consultCertificas(id, isBogota, numMatricula);

        assertNotNull(result);
        assertEquals(certificas, result.getCertificas());
        assertEquals(identification, result.getIdentificationSection());

        verify(certificationsGateway, times(1)).consultCertifications(id);
        verify(companyBasicInformationGateway, times(1)).getInformationByCompanyId(Long.parseLong(id));
        verify(certificasGateway, times(1)).consultCertificas(id);
        verify(certificasGateway, never()).consultCertificasOC(id, numMatricula);
        verify(identificationGateway, times(1)).getIdentificationSection(basicInformation.getRegisteredId(), Long.parseLong(id));
    }

}
package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.fiscalauditor.FiscalAuditor;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationGateway;
import com.sico.api.checkinline.infraestructure.gateways.fiscalauditor.FiscalAuditorGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiscalAuditorUseCaseTest {
    @Mock
    private CompanyBasicInformationGateway companyBasicInformationGateway;

    @Mock
    private FiscalAuditorGateway fiscalAuditorGateway;

    @InjectMocks
    private FiscalAuditorUseCase fiscalAuditorUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFiscalAuditorData() {
        Long companyId = 123L;
        CompanyBasicInformation companyBasicInformation = new CompanyBasicInformation();
        companyBasicInformation.setRegisteredId(2345L);
        companyBasicInformation.setCompanyId(12345L);

        FiscalAuditor fiscalAuditor = new FiscalAuditor();
        List<FiscalAuditor> expectedFiscalAuditors = Collections.singletonList(fiscalAuditor);

        when(companyBasicInformationGateway.getInformationByCompanyId(companyId)).thenReturn(companyBasicInformation);
        when(fiscalAuditorGateway.getFiscalAuditorData(12345L, 2345L)).thenReturn(expectedFiscalAuditors);

        List<FiscalAuditor> result = fiscalAuditorUseCase.getFiscalAuditorData(companyId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(fiscalAuditor, result.get(0));

        verify(companyBasicInformationGateway, times(1)).getInformationByCompanyId(companyId);
        verify(fiscalAuditorGateway, times(1)).getFiscalAuditorData(12345L, 2345L);
    }
}
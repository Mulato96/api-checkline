package com.sico.api.checkinline.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sico.api.checkinline.domain.models.financialReport.FinancialReport;
import com.sico.api.checkinline.infraestructure.gateways.financialReport.FinancialReportGateway;

public class FinancialReportUseCaseTest {

    @Mock
    private FinancialReportGateway financialReportGateway;

    @InjectMocks
    private FinancialReportUseCase financialReportUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        financialReportUseCase = new FinancialReportUseCase(financialReportGateway);
    }

    @Test
    void testGetFinancialReportLocalList() {
        // given
        String registrationNumber = "800611";
        FinancialReport report1 = new FinancialReport();
        report1.setRegisteredNum(registrationNumber);
        FinancialReport report2 = new FinancialReport();
        report2.setRegisteredNum("817855");
        List<FinancialReport> mockReports = List.of(report1, report2);

        // when
        when(financialReportGateway.getFinancialReportList(true, registrationNumber, null, "")).thenReturn(mockReports);

        List<FinancialReport> result = financialReportUseCase.getFinancialReportList(true, registrationNumber, null, "");

        // then
        assertEquals(2, result.size());
        assertEquals("800611", result.get(0).getRegisteredNum());
    }
    
}

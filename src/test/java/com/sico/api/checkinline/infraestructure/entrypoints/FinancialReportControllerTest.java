package com.sico.api.checkinline.infraestructure.entrypoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.sico.api.checkinline.domain.models.financialReport.FinancialReport;
import com.sico.api.checkinline.domain.models.financialReport.FinancialReportLocal;
import com.sico.api.checkinline.domain.usecases.FinancialReportUseCase;


class FinancialReportControllerTest {

    private FinancialReportController controller;
    
    @Mock
    private FinancialReportUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new FinancialReportController(useCase);
    }

    @Test
    void shouldReturnLocalFinancialReports_whenIsBogotaIsTrue() throws Exception {        

        // given
        List<FinancialReport> mockReports = Arrays.asList(
                new FinancialReport(),
                new FinancialReport()
        );

        // when
        when(useCase.getFinancialReportList(true, "", null, "800611")).thenReturn(mockReports);

        ResponseEntity<?> response = controller.getFinancialReport(true, "", null, "800611");
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, ((List<FinancialReportLocal>) response.getBody()).size());          

        // Verificar interacción
        verify(useCase, times(1)).getFinancialReportList(true, "", null, "800611");
    }

     @Test
    void shouldReturnFinancialReports_whenIsBogotaIsFalse() throws Exception {
        // given
        List<FinancialReport> mockReports = Arrays.asList(
                new FinancialReport(),
                new FinancialReport()
        );

        // Configuración de Mockito
        when(useCase.getFinancialReportList(false, "00254905", null, "")).thenReturn(mockReports);

        ResponseEntity<?> response = controller.getFinancialReport(false, "00254905", null, "");
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, ((List<FinancialReport>) response.getBody()).size());    

        // Verificar interacción
        verify(useCase, times(1)).getFinancialReportList(false, "00254905", null, "");
    }



}

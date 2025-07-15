package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImporterExporterReport;
import com.sico.api.checkinline.domain.usecases.ImporterExporterUseCase;
import com.sico.api.testdatabuilder.ImporterExporterReportBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
class ImporterExporterRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImporterExporterUseCase importerExporterUseCase;

    @MockBean
    private MessageTranslator messageTranslator;

    @InjectMocks
    private ImporterExporterRestController controller;


    @Test
    public void testGetExportData() throws Exception {
        // Arrange
        String idClient = "123";

        ImporterExporterReport importerExporterReport = ImporterExporterReportBuilder.anImporterExporterReport().build();

        given(importerExporterUseCase.consultImportExportData(idClient))
                .willReturn(importerExporterReport);

        given(messageTranslator.getMessage("Data found", new Object[]{idClient}))
                .willReturn("Data found");

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/import-export/{idClient}",idClient).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}
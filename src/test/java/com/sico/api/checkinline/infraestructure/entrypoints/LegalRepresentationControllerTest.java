package com.sico.api.checkinline.infraestructure.entrypoints;


import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.domain.models.legalrepresentation.LegalExistenceReport;
import com.sico.api.checkinline.domain.usecases.LegalRepresentationUseCase;
import com.sico.api.testdatabuilder.LegalExistenceReportDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
class LegalRepresentationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LegalRepresentationUseCase legalRepresentationUseCase;

    @MockBean
    private MessageTranslator messageTranslator;

    @InjectMocks
    private LegalRepresentationController legalRepresentationController;


    @Test
    void testGetLegalRepresentation() throws Exception  {

        String id = "123";
        boolean isBogota = true;
        String numMatricula="2312";
        LegalExistenceReport report= LegalExistenceReportDataBuilder.anLegalExistenceReport().build();
        given(legalRepresentationUseCase.consultCertificas(id, isBogota, numMatricula)).willReturn(report);
        given(messageTranslator.getMessage("data.found", new Object[]{id})).willReturn("Data found");

        mockMvc.perform(MockMvcRequestBuilders.get("/legal-existence/{id}/{isBogota}/{numMatricula}", id, isBogota, numMatricula)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}
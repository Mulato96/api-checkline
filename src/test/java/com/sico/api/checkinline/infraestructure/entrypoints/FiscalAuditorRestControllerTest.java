package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.fiscalauditor.FiscalAuditor;
import com.sico.api.checkinline.domain.usecases.FiscalAuditorUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
class FiscalAuditorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FiscalAuditorUseCase useCase;

    @MockBean
    private MessageTranslator messageTranslator;

    @InjectMocks
    private FiscalAuditorRestController controller;

    @Test
    void testGetInformationData() throws Exception {
        Long companyId = 123L;
        FiscalAuditor fiscalAuditor = new FiscalAuditor();
        List<FiscalAuditor> fiscalAuditors = Collections.singletonList(fiscalAuditor);

        given(useCase.getFiscalAuditorData(companyId)).willReturn(fiscalAuditors);
        given(messageTranslator.getMessage("data.found", new Object[]{companyId})).willReturn("Data found");

        mockMvc.perform(MockMvcRequestBuilders.get("/fiscal-auditor/{companyId}", companyId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Data found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0]").exists());
    }

}
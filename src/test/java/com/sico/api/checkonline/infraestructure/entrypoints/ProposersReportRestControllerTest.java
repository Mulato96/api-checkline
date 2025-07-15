package com.sico.api.checkonline.infraestructure.entrypoints;
import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Proposers.ProposersReport;
import com.sico.api.checkinline.domain.usecases.ProposerReportUseCase;
import com.sico.api.checkinline.infraestructure.entrypoints.ProposersReportRestController;
import com.sico.api.testdatabuilder.ProposersReportBuilder;
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

import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
public class ProposersReportRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProposerReportUseCase useCase;

    @MockBean
    private MessageTranslator messageTranslator;

    @InjectMocks
    private ProposersReportRestController controller;

    @Test
    public void testConsultReportInformation() throws Exception {
        String id= "8604018268";

        ProposersReport proposersReport = ProposersReportBuilder.anProposersReport().build();

        given(useCase.consultReportInformation(id))
                .willReturn(proposersReport);

        given(messageTranslator.getMessage("Data found", new Object[]{id}))
                .willReturn("Data found");

        mockMvc.perform(MockMvcRequestBuilders.get("/proposers-report/{id}",id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}

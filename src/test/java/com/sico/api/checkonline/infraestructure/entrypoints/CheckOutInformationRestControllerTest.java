package com.sico.api.checkonline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.general.CompanyBasicData;
import com.sico.api.checkinline.domain.models.general.InformationReport;
import com.sico.api.checkinline.domain.usecases.CheckOutInformationUseCase;
import com.sico.api.checkinline.infraestructure.entrypoints.CheckOutInformationRestController;
import com.sico.api.testdatabuilder.InformationReportDataBuilder;
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

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
class CheckOutInformationRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CheckOutInformationUseCase useCase;

    @MockBean
    private MessageTranslator messageTranslator;

    @InjectMocks
    private CheckOutInformationRestController controller;

    @Test
    void testGetInformationByCompany() throws Exception {
        // Given
        String companyId = "123";
        Boolean isBogota = true;

        InformationReport informationReport = InformationReportDataBuilder.anInformationReport().build();

        given(useCase.checkOutInformationReport(companyId, isBogota))
                .willReturn(informationReport);

        given(messageTranslator.getMessage("Data found", new Object[]{companyId}))
                .willReturn("Data found");

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/information/company/{companyId}/is-bogota/{isBogota}", companyId, isBogota).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
    }

    @Test
    void testGetInformationByDocumentNumber() throws Exception {
        // Given
        String documentNumber = "ABC123";
        String tuition = "TU123";

        InformationReport informationReport = InformationReportDataBuilder.anInformationReport().build();

        given(useCase.checkOutCompanyInformationReport(documentNumber, tuition))
                .willReturn(informationReport);

        given(messageTranslator.getMessage(any(), any()))
                .willReturn("Data found");

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/information/document-number/{documentNumber}/tuition/{tuition}", documentNumber, tuition).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }


    @Test
    void testGetInformationData() throws Exception {
        // Given
        String companyId = "123";
        boolean isBogota = true;
        CompanyBasicData companyBasicData = CompanyBasicData.builder()
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

        given(useCase.checkOutCompanyBasicData(companyId, isBogota)).willReturn(companyBasicData);
        given(messageTranslator.getMessage("data.found", new Object[]{companyId})).willReturn("Data found");

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/information/company/basic-data/{companyId}/{isBogota}", companyId, isBogota)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Data found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.idNumber").value("idNumber"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.register").value("register"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.registerStatus").value("registerStatus"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.category").value("category"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.commerceChamber").value("commerceChamber"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.ciiu").value("ciiu"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.economicActivity").value("economicActivity"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.organizationType").value("organizationType"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.companyName").value("companyName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cancellationDate").value(LocalDate.now().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.idType").value("idType"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.registerDate").value(LocalDate.now().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.address").value("address"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.renewalDate").value(LocalDate.now().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.municipality").value("municipality"));
    }
}

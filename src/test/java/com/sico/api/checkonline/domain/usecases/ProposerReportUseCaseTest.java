package com.sico.api.checkonline.domain.usecases;

import com.sico.api.checkinline.domain.models.Proposers.*;
import com.sico.api.checkinline.domain.usecases.ProposerReportUseCase;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposerReportUseCaseTest {
    @Mock
    private GeneralDataReportGateway generalDataReportGateway;
    @Mock
    private FinancialInformationReportGateway financialInformationReportGateway;
    @Mock
    private FinancialCapacityReportGateway financialCapacityReportGateway;
    @Mock
    private OrganizationalCapacityReportGateway organizationalCapacityReportGateway;
    @Mock
    private ClasificationReportGateway clasificationReportGateway;
    @Mock
    private ExperienceReportGateway experienceReportGateway;

    @InjectMocks
    private ProposerReportUseCase proposerReportUseCase;


    @Test
    public void testConsultRpoertInformation(){
        String id="000008604018268";

        GeneralDataReport generalDataReport =null;
        FinancialInformationReport financialInformationReport =null;
        FinancialCapacityReport financialCapacityReport =null;
        OrganizationalCapacityReport organizationalCapacityReport =null;
        List<ClasificationReport> clasificationReports =null;
        List<ExperienceReport> experienceReports =null;

        //when
        when(generalDataReportGateway.consultGeneralData(id)).thenReturn(generalDataReport);
        when(financialInformationReportGateway.consultFinancialInformation(id)).thenReturn(financialInformationReport);
        when(financialCapacityReportGateway.consultFinancialCapacity(id)).thenReturn(financialCapacityReport);
        when(organizationalCapacityReportGateway.consultOrganizationCapacity(id)).thenReturn(organizationalCapacityReport);
        when(clasificationReportGateway.consultClasification(id)).thenReturn(clasificationReports);
        when(experienceReportGateway.consultExperience(id)).thenReturn(experienceReports);

        ProposersReport data = this.proposerReportUseCase.consultReportInformation(id);

        //Then
        verify(generalDataReportGateway, times(1)).consultGeneralData(id);
        verify(financialInformationReportGateway, times(1)).consultFinancialInformation(id);
        verify(financialCapacityReportGateway, times(1)).consultFinancialCapacity(id);
        verify(organizationalCapacityReportGateway, times(1)).consultOrganizationCapacity(id);
        verify(clasificationReportGateway, times(1)).consultClasification(id);
        verify(experienceReportGateway, times(1)).consultExperience(id);

        assertNotNull(data);
    }

    @Test
    public  void  testConsultProposer(){
        String id="1234";
        ClasificationReport clasificationReport = new ClasificationReport();
        List<ClasificationReport> expectedClasificationReport = Collections.singletonList(clasificationReport);

        when(clasificationReportGateway.consultClasification(id)).thenReturn(expectedClasificationReport);

        List<ClasificationReport> request = proposerReportUseCase.consultProposer(id);

        assertNotNull(request);
        assertEquals(1, request.size());
        assertEquals(clasificationReport, request.get(0));


        verify(clasificationReportGateway, times(1)).consultClasification(id);

    }
}

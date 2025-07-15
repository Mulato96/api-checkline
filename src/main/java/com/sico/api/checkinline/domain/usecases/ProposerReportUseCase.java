package com.sico.api.checkinline.domain.usecases;


import com.sico.api.checkinline.domain.models.Proposers.ClasificationReport;
import com.sico.api.checkinline.domain.models.Proposers.ProposersReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProposerReportUseCase {

    private final GeneralDataReportGateway generalDataReportGateway;
    private final FinancialInformationReportGateway financialInformationReportGateway;
    private final FinancialCapacityReportGateway financialCapacityReportGateway;
    private final OrganizationalCapacityReportGateway organizationalCapacityReportGateway;
    private final ClasificationReportGateway clasificationReportGateway;
    private final ExperienceReportGateway experienceReportGateway;

    public ProposersReport consultReportInformation(String id){
        return ProposersReport.builder()
                .generalDataReport(generalDataReportGateway.consultGeneralData(id))
                .financialInformationReport(financialInformationReportGateway.consultFinancialInformation(id))
                .financialCapacityReport(financialCapacityReportGateway.consultFinancialCapacity(id))
                .organizationalCapacityReport(organizationalCapacityReportGateway.consultOrganizationCapacity(id))
                .clasificationReports(clasificationReportGateway.consultClasification(id))
                .experienceReports(experienceReportGateway.consultExperience(id))
                .build();
    }

    public List<ClasificationReport> consultProposer(String id){
        return clasificationReportGateway.consultClasification(id);
    }
}

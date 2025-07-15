package com.sico.api.checkinline.domain.models.Proposers;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProposersReport {
    private GeneralDataReport generalDataReport;

    private FinancialInformationReport financialInformationReport;

    private FinancialCapacityReport financialCapacityReport;

    private OrganizationalCapacityReport organizationalCapacityReport;

    private List<ClasificationReport> clasificationReports;

    private List<ExperienceReport> experienceReports;
}

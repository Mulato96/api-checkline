package com.sico.api.testdatabuilder;
import com.sico.api.checkinline.domain.models.Proposers.*;

import java.util.List;

public class ProposersReportBuilder {
    private GeneralDataReport generalDataReport;

    private FinancialInformationReport financialInformationReport;

    private FinancialCapacityReport financialCapacityReport;

    private OrganizationalCapacityReport organizationalCapacityReport;

    private List<ClasificationReport> clasificationReports;

    private List<ExperienceReport> experienceReports;

    public ProposersReportBuilder withGeneralData(GeneralDataReport generalDataReport){
        this.generalDataReport = generalDataReport;
        return  this;
    }

    public ProposersReportBuilder withfinancialInformation(FinancialInformationReport financialInformationReport){
        this.financialInformationReport = financialInformationReport;
        return  this;
    }

    public ProposersReportBuilder withfinancialCapacity(FinancialCapacityReport financialCapacityReport){
        this.financialCapacityReport = financialCapacityReport;
        return  this;
    }

    public ProposersReportBuilder withorganizationalCapacity(OrganizationalCapacityReport organizationalCapacityReport){
        this.organizationalCapacityReport = organizationalCapacityReport;
        return  this;
    }

    public ProposersReportBuilder withclasification(List<ClasificationReport> clasificationReports){
        this.clasificationReports = clasificationReports;
        return  this;
    }

    public ProposersReportBuilder withexperience(List<ExperienceReport> experienceReports){
        this.experienceReports = experienceReports;
        return  this;
    }

    public ProposersReport build() {
        return new ProposersReport(
                generalDataReport,
                financialInformationReport,
                financialCapacityReport,
                organizationalCapacityReport,
                clasificationReports,
                experienceReports
        );
    }

    public static ProposersReportBuilder anProposersReport() {
        return new ProposersReportBuilder();
    }
}

package com.sico.api.testdatabuilder;

import com.sico.api.checkinline.domain.models.general.InformationReport;
import com.sico.api.checkinline.domain.models.general.report.*;

import java.util.List;

public class InformationReportDataBuilder {
    private GeneralInformation generalInformation;
    private List<Renewal> renewals;
    private List<Employee> employees;
    private List<LegalRepresentative> legalRepresentatives;
    private List<Linked> linkeds;
    private List<Executive> executives;
    private List<AssociatedEstablishment> associatedEstablishments;
    private List<NetSalesPerYear> netSalesPerYears;
    private List<AssetPerYear> assetPerYears;
    private List<CompanySize> companySizes;

    public InformationReportDataBuilder withGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
        return this;
    }

    public InformationReportDataBuilder withRenewals(List<Renewal> renewals) {
        this.renewals = renewals;
        return this;
    }

    public InformationReportDataBuilder withEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public InformationReportDataBuilder withLegalRepresentative(List<LegalRepresentative> legalRepresentatives) {
        this.legalRepresentatives = legalRepresentatives;
        return this;
    }

    public InformationReportDataBuilder withLinkeds(List<Linked> linkeds) {
        this.linkeds = linkeds;
        return this;
    }

    public InformationReportDataBuilder withExecutives(List<Executive> executives) {
        this.executives = executives;
        return this;
    }

    public InformationReportDataBuilder withAssociatedEstablishments(List<AssociatedEstablishment> associatedEstablishments) {
        this.associatedEstablishments = associatedEstablishments;
        return this;
    }

    public InformationReportDataBuilder withNetSalesPerYears(List<NetSalesPerYear> netSalesPerYears) {
        this.netSalesPerYears = netSalesPerYears;
        return this;
    }

    public InformationReportDataBuilder withAssetPerYears(List<AssetPerYear> assetPerYears) {
        this.assetPerYears = assetPerYears;
        return this;
    }

    public InformationReportDataBuilder withCompanySizes(List<CompanySize> companySizes) {
        this.companySizes = companySizes;
        return this;
    }

    public InformationReport build() {
        return new InformationReport(
                generalInformation,
                true,
                true,
                true,
                renewals,
                employees,
                legalRepresentatives,
                linkeds,
                executives,
                associatedEstablishments,
                netSalesPerYears,
                assetPerYears,
                companySizes
        );
    }

    public static InformationReportDataBuilder anInformationReport() {
        return new InformationReportDataBuilder();
    }
}


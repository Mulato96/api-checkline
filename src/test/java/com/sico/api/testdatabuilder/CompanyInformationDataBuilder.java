package com.sico.api.testdatabuilder;

import com.sico.api.checkinline.domain.models.general.report.CompanyInformation;

public class CompanyInformationDataBuilder {
    private String idCompany;
    private Boolean isBogota;

    public CompanyInformationDataBuilder withIdCompany(String idCompany) {
        this.idCompany = idCompany;
        return this;
    }

    public CompanyInformationDataBuilder withIsBogota(Boolean isBogota) {
        this.isBogota = isBogota;
        return this;
    }

    public CompanyInformation build() {
        CompanyInformation companyInformation = new CompanyInformation();
        companyInformation.setIdCompany(idCompany);
        companyInformation.setIsBogota(isBogota);
        return companyInformation;
    }

    public static CompanyInformationDataBuilder aCompanyInformation() {
        return new CompanyInformationDataBuilder();
    }
}

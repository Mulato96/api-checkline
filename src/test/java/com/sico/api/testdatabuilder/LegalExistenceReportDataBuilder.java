package com.sico.api.testdatabuilder;

import com.sico.api.checkinline.domain.models.Proposers.FinancialInformationReport;
import com.sico.api.checkinline.domain.models.Proposers.GeneralDataReport;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.domain.models.legalrepresentation.Identification;
import com.sico.api.checkinline.domain.models.legalrepresentation.LegalExistenceReport;

import java.util.List;

public class LegalExistenceReportDataBuilder {
    private List<Certificas> certificas;
    private Identification identification;
    private String rup;

    public LegalExistenceReportDataBuilder withCertificas(List<Certificas> certificas){
        this.certificas = certificas;
        return  this;
    }

    public LegalExistenceReportDataBuilder withIdentification(Identification identification){
        this.identification = identification;
        return  this;
    }

    public LegalExistenceReport build(){
        return new LegalExistenceReport(
                certificas,
                identification,
                rup
        );
    }

    public static LegalExistenceReportDataBuilder anLegalExistenceReport(){
        return new LegalExistenceReportDataBuilder();
    }

}

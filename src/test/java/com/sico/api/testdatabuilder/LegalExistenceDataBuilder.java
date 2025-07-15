package com.sico.api.testdatabuilder;

import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.domain.models.legalrepresentation.LegalExistence;

import java.util.List;

public class LegalExistenceDataBuilder {
    private List<Certificas> certificas;
    private String rup;

    public LegalExistenceDataBuilder withCertificas(List<Certificas> certificas){
        this.certificas = certificas;
        return this;
    }

    public LegalExistenceDataBuilder withRup(String rup){
        this.rup = rup;
        return this;
    }

    public LegalExistence build(){
        return new LegalExistence(
               certificas,
               rup
        );
    }

    public static LegalExistenceDataBuilder anLegalExistence(){
        return new LegalExistenceDataBuilder();
    }
}

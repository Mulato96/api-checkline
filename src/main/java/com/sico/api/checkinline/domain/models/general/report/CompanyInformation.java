package com.sico.api.checkinline.domain.models.general.report;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompanyInformation  implements Serializable {

    private String idCompany;

    private Boolean isBogota;
}

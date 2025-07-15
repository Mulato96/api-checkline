package com.sico.api.checkinline.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanySearchFilterEntity {

    private String generalInformationForm;

    private Integer corporateNameInitialsFilter;

    private Integer identificationFilter;

    private Integer registrationFilter;

}

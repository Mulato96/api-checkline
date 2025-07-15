package com.sico.api.checkinline.domain.models.general.report;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AssociatedEstablishment implements Serializable {

    private String corporateName;

    private String house;

    private String register;

    private String registerStatus;

    private String category;

    private String address;

    private String renewalDate;

    private Integer lastYearRenewal;
}

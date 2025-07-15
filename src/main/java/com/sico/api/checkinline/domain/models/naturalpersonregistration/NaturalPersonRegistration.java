package com.sico.api.checkinline.domain.models.naturalpersonregistration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NaturalPersonRegistration {

    private String registrationNumber;

    private int identificationTypeId;

    private String registeredName;

    private String identificationNumber;

    private String verificationDigit;

    private String registrationDate;

    private String notificationAddress;

    private String notificationCity;

    private String commercialAddress;

    private String commercialCityDescription;

    private String commercialEmail;

    private String lastRenewalDate;

    private int lastRenewedYearId;

    private double totalLiabilities;

    private String activityDescriptionLevel4;

    private String taxRegimeDescription;
}

package com.sico.api.checkinline.domain.models.legalrepresentation;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Identification {

    private String businessName;

    private String identificationType;

    private String identificationNumber;

    private String chamberOfCommerce;

    private String registrationNumber;

    private String legalOrganization;

    private String address;

    private String renewalDate;

    private String lastRenewedYear;

    private String judicialNotificationAddress;

    private String judicialNotificationMunicipality;

    private String judicialNotificationEmail;

    private String commercialAddress;

    private String commercialMunicipality;

    private String commercialEmail;

    private String commercialPhone;

    private String primaryEconomicActivity;
}

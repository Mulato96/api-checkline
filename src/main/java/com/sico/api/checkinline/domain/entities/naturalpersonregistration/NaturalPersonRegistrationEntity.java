package com.sico.api.checkinline.domain.entities.naturalpersonregistration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class NaturalPersonRegistrationEntity {

        @Id
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

package com.sico.api.checkinline.domain.models.general.report;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Mapeo informacion general
 */
@Getter
@Setter
public class GeneralInformation implements Serializable {

  private String corporateName;

  private String identificationType;

  private String identification;

  private String register;

  private String acronym;

  private String legalOrganization;

  private String house;

  private String registerStatus;

  private String registerDate;

  private String renewalDate;

  private Integer lastYearRenewal;

  private String cancellationDate;

  private String foreclosure;

  private String concordat;

  private String businessAddress;

  private String businessDepartment;

  private String businessCity;

  private String businessZipCode;

  private String businessPhone;

  private String businessMail;

  private String businessAirmail;

  private String businessWebAddress;

  private String legalAddress;

  private String legalDepartment;

  private String legalCity;

  private String legalZipCode;

  private String legalPhone;

  private String legalMail;

  private String legalAirmail;

  private String legalWebAddress;

  private String longitude;

  private String latitude;

  private String ciiu1;

  private String descriptionCiiu1;

  private String ciiu2;

  private String descriptionCiiu2;

  private String ciiu3;

  private String descriptionCiiu3;

  private String ciiu4;

  private String descriptionCiiu4;

  private String companyObject;

  private String facultiesLegalRepresentative;

  private String companyId;

  private String companySize;
  private String businessGroup;
  private String regimeType;
  private String businessCategory;
  private String numberOfEmployees;
  private String settlementIndicator;
  private String descriptionEconomicActivity;
  private String dateData;
  private String statusAffiliation;
  private String registerId;
  private List<Reference> references;
}

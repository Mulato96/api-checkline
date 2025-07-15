package com.sico.api.checkinline.domain.models.laft.verification;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaftRequestEvent implements Serializable {

  private String companyName;
  private String identificationNumber;
  private String identificationType;
  private String identificationTypeLabel;
  private String legalNature;
  private String firstName;
  private String secondName;
  private String firstLastName;
  private String secondLastName;
}

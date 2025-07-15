package com.sico.api.checkinline.domain.models.laft.verification;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerificationLaftResponse implements Serializable {

  private String identificationType;
  private String identificationNumber;
  private String companyName;

  private String identificationTypeLabel;
  private String natureLegalLabel;
}

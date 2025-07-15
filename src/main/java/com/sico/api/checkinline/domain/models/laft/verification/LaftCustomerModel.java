package com.sico.api.checkinline.domain.models.laft.verification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LaftCustomerModel {

  private String firstName;
  private String lastFirstName;
  private String companyName;
}

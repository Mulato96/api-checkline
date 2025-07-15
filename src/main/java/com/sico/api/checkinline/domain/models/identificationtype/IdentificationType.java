package com.sico.api.checkinline.domain.models.identificationtype;

import static java.util.Objects.nonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentificationType {

  private String id;
  private String description;
  private String descriptionShort;
  private String labelLaft;
  private String legalNature;
  private Boolean useLaft;

  public IdentificationTypeShort getIdentificationTypeShort() {
    if (nonNull(this.descriptionShort) && !this.descriptionShort.isEmpty()) {
      try {
        String identificationTypeConvert = this.descriptionShort.replace(".", "").trim();
        return IdentificationTypeShort.valueOf(identificationTypeConvert);
      } catch (IllegalArgumentException e) {
        return null;
      }
    }
    return null;
  }
}

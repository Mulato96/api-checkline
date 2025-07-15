package com.sico.api.checkinline.domain.models.laft.verification;

import static java.util.Objects.nonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sico.api.checkinline.domain.models.identificationtype.IdentificationTypeShort;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"checkedErrors", "identificationTypeShort", "identificationTypeLabel",
    "natureLegalLabel"})
public class VerificationLaftRequest implements Serializable {

  @JsonProperty("Tipo de identificación")
  private String identificationType;

  @JsonProperty("Número de identificación")
  private String identificationNumber;

  @JsonProperty("Nombre / Razón Social")
  private String companyName;

  private List<Boolean> checkedErrors;

  private String identificationTypeLabel;
  private String natureLegalLabel;

  public IdentificationTypeShort getIdentificationTypeShort() {
    if (nonNull(this.identificationType) && !this.identificationType.isEmpty()) {
      try {
        String identificationTypeConvert = this.identificationType.replace(".", "").trim();
        return IdentificationTypeShort.valueOf(identificationTypeConvert);
      } catch (IllegalArgumentException e) {
        return null;
      }
    }
    return null;
  }
}

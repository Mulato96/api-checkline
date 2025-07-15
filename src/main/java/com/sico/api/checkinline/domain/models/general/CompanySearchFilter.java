package com.sico.api.checkinline.domain.models.general;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySearchFilter {
    private String generalInformationForm;

    private Integer corporateNameInitialsFilter;

    private Integer identificationFilter;

    private Integer registrationFilter;

}

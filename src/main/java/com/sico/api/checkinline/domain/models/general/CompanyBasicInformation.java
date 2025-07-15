package com.sico.api.checkinline.domain.models.general;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyBasicInformation implements Serializable {
    private Long companyId;
    private Long registeredId;
}

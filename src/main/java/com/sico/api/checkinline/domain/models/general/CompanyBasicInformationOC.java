package com.sico.api.checkinline.domain.models.general;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyBasicInformationOC implements Serializable {
    private Long identification;
    private Long registeredId;
    private Long chamberId;
}

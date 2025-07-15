package com.sico.api.checkinline.domain.models.legalrepresentation;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LegalExistenceReport {

    private List<Certificas> certificas;

    private Identification identificationSection;

    private String rup;

}

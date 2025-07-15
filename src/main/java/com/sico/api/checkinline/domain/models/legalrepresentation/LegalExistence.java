package com.sico.api.checkinline.domain.models.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificationsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LegalExistence {
    private List<Certificas> certificas;
    private String rup;
}

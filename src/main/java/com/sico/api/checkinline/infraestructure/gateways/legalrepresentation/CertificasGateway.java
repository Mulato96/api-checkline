package com.sico.api.checkinline.infraestructure.gateways.legalrepresentation;

import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;

import java.util.List;

public interface CertificasGateway {
    List<Certificas> consultCertificas(String id);
    List<Certificas> consultCertificasOC(String numId, String numMatricula);
}

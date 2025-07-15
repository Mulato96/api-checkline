package com.sico.api.checkinline.infraestructure.gateways.legalrepresentation;

import com.sico.api.checkinline.domain.models.legalrepresentation.Certifications;

public interface CertificationsGateway {
    Certifications consultCertifications(String id);
}

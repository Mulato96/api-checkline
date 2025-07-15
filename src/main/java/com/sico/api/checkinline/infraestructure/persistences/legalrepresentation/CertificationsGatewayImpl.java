package com.sico.api.checkinline.infraestructure.persistences.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificationsEntity;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certifications;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificationsGateway;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.CertificasMapper;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.CertificationsMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CertificationsGatewayImpl implements CertificationsGateway {
    private final JpaCertificationsRepository repository;
    private final CertificationsMapper mapper;

    @Override
    public Certifications consultCertifications(String id) {
        return mapper.toDto(repository.consultCertifications(id));
    }
}

package com.sico.api.checkinline.infraestructure.persistences.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificasEntity;
import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificationsEntity;
import com.sico.api.checkinline.domain.models.legalrepresentation.Certificas;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.CertificasGateway;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.CertificasMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CertificasGatewayImpl implements CertificasGateway {

    private final JpaCertificasRepository repository;
    private final CertificasMapper mapper;
    @Override
    public List<Certificas> consultCertificas(String id) {
        return mapper.toDto(repository.consultCertificas(id));
    }

    @Override
    public List<Certificas> consultCertificasOC(String numId, String numMatricula) {
        return mapper.toDto(repository.consultCertificasOC(numId, numMatricula));
    }
}

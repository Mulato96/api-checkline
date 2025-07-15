package com.sico.api.checkinline.infraestructure.persistences.legalrepresentation;


import com.sico.api.checkinline.domain.models.legalrepresentation.Identification;
import com.sico.api.checkinline.infraestructure.gateways.legalrepresentation.IdentificationGateway;
import com.sico.api.checkinline.infraestructure.mappers.legalrepresentation.IdentificationMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdentificationGatewayImpl implements IdentificationGateway {

    private final JpaIdentificationRepository repository;
    private final IdentificationMapper mapper;

    @Override
    public Identification getIdentificationSection(Long id_matriculado, Long id_cliente) {
        return mapper.toDto(repository.getIdentificationSection(id_matriculado, id_cliente));
    }

    @Override
    public Identification getIdentificationSectionOC(String numMatricula, Long idCliente) {
        return mapper.toDto(repository.getIdentificationSectionOC(numMatricula, idCliente));
    }
}

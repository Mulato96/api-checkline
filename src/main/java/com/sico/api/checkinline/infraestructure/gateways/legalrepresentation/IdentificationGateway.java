package com.sico.api.checkinline.infraestructure.gateways.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.IdentificationEntity;
import com.sico.api.checkinline.domain.models.legalrepresentation.Identification;

public interface IdentificationGateway {
    Identification getIdentificationSection(Long id_matriculado, Long id_cliente);
    Identification getIdentificationSectionOC(String id_matriculado, Long idCliente);
}

package com.sico.api.checkinline.infraestructure.persistences.linkedverification;


import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.infraestructure.gateways.linkedverification.LinkedVerificationGateway;
import com.sico.api.checkinline.infraestructure.mappers.linkedverification.LinkedVerificationMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LinkedVerificationGatewayImpl implements LinkedVerificationGateway {

    private final LinkedVerificationRepository repository;
    private final LinkedVerificationMapper mapper;

    @Override
    public List<LinkedVerification> getLinkedVerification(String identificationType,String identificationNumber) {
        return mapper.toDto(repository.findLinkedVerification(identificationType,identificationNumber));
    }
}

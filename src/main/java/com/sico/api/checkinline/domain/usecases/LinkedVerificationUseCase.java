package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.infraestructure.gateways.linkedverification.LinkedVerificationGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LinkedVerificationUseCase {

    private final LinkedVerificationGateway linkedVerificationGateway;

    public List<LinkedVerification> getLinkedVerifications(String identificationType, String identificationNumber){
        String paddedIdentificationNumber = String.format("%015d", Long.parseLong(identificationNumber));
        return linkedVerificationGateway.getLinkedVerification(identificationType, paddedIdentificationNumber);
    }

}

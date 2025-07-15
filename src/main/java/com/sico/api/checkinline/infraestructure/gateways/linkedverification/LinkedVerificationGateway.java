package com.sico.api.checkinline.infraestructure.gateways.linkedverification;

import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;

import java.util.List;

public interface LinkedVerificationGateway {

    List<LinkedVerification> getLinkedVerification(String identificationType,String identificationNumber);
}

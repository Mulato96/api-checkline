package com.sico.api.checkinline.domain.usecases.naturalpersonregistration;

import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.infraestructure.gateways.naturalpersonregistration.NaturalPersonRegistrationGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class NaturalPersonRegistrationUseCase {

    private final NaturalPersonRegistrationGateway naturalPersonRegistrationGateway;

    public List<NaturalPersonRegistration> getNaturalPersonRegistration(String registrationNumber, String chamberId) {
       return naturalPersonRegistrationGateway.getNaturalPersonRegistration(registrationNumber, chamberId);
    }
}

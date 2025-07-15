package com.sico.api.checkinline.infraestructure.gateways.naturalpersonregistration;

import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;

import java.util.List;


public interface NaturalPersonRegistrationGateway {

    List<NaturalPersonRegistration> getNaturalPersonRegistration (String registrationNumber, String chamberId);
}

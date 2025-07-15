package com.sico.api.checkinline.infraestructure.persistences.naturalpersonregistration;

import com.sico.api.checkinline.domain.entities.naturalpersonregistration.NaturalPersonRegistrationEntity;
import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.infraestructure.gateways.naturalpersonregistration.NaturalPersonRegistrationGateway;
import com.sico.api.checkinline.infraestructure.mappers.naturalpersonregistration.NaturalPersonRegistrationMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NaturalPersonRegistrationGatewayImpl implements NaturalPersonRegistrationGateway {

    private final NaturalPersonRegistrationRepository repository;

    private final NaturalPersonRegistrationMapper mapper;

    @Override
    public List<NaturalPersonRegistration> getNaturalPersonRegistration(String registrationNumber, String chamberId) {
        List<NaturalPersonRegistrationEntity> naturalPersonRegistration = repository.findNaturalPersonRegistration(registrationNumber);
        if(!naturalPersonRegistration.isEmpty()){
            return mapper.toDto(naturalPersonRegistration);
        }else{

            return mapper.toDto(repository.findNaturalPersonRegistrationOtherChamberCommerce(registrationNumber, chamberId));
        }
    }
}

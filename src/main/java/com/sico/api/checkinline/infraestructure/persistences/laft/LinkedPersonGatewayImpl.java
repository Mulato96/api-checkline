package com.sico.api.checkinline.infraestructure.persistences.laft;

import com.sico.api.checkinline.domain.models.laft.LinkedPerson;
import com.sico.api.checkinline.infraestructure.gateways.laft.LinkedPersonGateway;
import com.sico.api.checkinline.infraestructure.mappers.laft.LinkedPersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class LinkedPersonGatewayImpl implements LinkedPersonGateway {

    private final JpaLinkedPersonRepository repository;
    private final LinkedPersonMapper mapper;
    @Override
    public Page<LinkedPerson> getLinkedPersonData(String registrationNumber, Pageable pageable) {
        return repository.findLinkedPersonsByRegistrationNumber(registrationNumber, pageable).map(mapper::toDto);
    }
}

package com.sico.api.checkinline.infraestructure.persistences.laft;

import com.sico.api.checkinline.domain.models.laft.LinkedPerson;
import com.sico.api.checkinline.infraestructure.gateways.laft.LinkedPersonOCGateway;
import com.sico.api.checkinline.infraestructure.mappers.laft.LinkedPersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class LinkedPersonOCGatewayImpl implements LinkedPersonOCGateway {

    private final JpaLinkedPersonOCRepository repository;
    private final LinkedPersonMapper mapper;

    @Override
    public Page<LinkedPerson> getLinkedPersonData(String registrationNumber, Long idChamber, Pageable pageable) {
        return repository.findLinkedPersonsByRegistrationNumberAndIdChamber(registrationNumber, idChamber, pageable).map(mapper::toDto);
    }
}

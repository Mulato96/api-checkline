package com.sico.api.checkinline.infraestructure.gateways.laft;

import com.sico.api.checkinline.domain.models.laft.LinkedPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LinkedPersonOCGateway {
    Page<LinkedPerson> getLinkedPersonData(String registrationNumber, Long idChamber, Pageable pageable);
}

package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.AssociatedEstablishmentGateway;
import com.sico.api.checkinline.domain.models.general.report.AssociatedEstablishment;
import com.sico.api.checkinline.infraestructure.mappers.AssociatedEstablishmentMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AssociatedEstablishmentGatewayImpl implements AssociatedEstablishmentGateway {

    private final JpaAssociatedEstablishmentRepository repository;
    private final AssociatedEstablishmentMapper mapper;

    @Override
    public List<AssociatedEstablishment> checkOutAssociatedEstablishments(String companyId,
                                                                          Boolean isBogota) {
        return mapper.toDto(repository.checkOutAssociatedEstablishments(companyId, isBogota));
    }
}

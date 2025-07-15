package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.models.general.CompanyBasicData;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicDataGateway;
import com.sico.api.checkinline.infraestructure.mappers.CompanyBasicDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class CompanyBasicDataGatewayImpl implements CompanyBasicDataGateway {

    private final JpaCompanyBasicDataRepository repository;
    private final CompanyBasicDataMapper mapper;

    @Override
    public CompanyBasicData getCompanyBasicData(Long registeredId, Long clientId) {
        return mapper.toDto(repository.getCompanyBasicData(registeredId, clientId));
    }

    @Override
    public CompanyBasicData getCompanyBasicDataOC(String registeredId, Long commerceId) {
        return mapper.toDto(repository.getCompanyBasicDataOC(registeredId, commerceId));
    }
}

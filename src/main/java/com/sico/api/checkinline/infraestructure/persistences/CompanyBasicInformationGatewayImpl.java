package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationGateway;
import com.sico.api.checkinline.infraestructure.mappers.CompanyBasicInformationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class CompanyBasicInformationGatewayImpl implements CompanyBasicInformationGateway {

    private final JpaCompanyBasicInformationRepository repository;
    private final CompanyBasicInformationMapper mapper;

    @Override
    public CompanyBasicInformation getInformationByCompanyId(Long companyId) {
        return mapper.toDto(repository.consultCompanyBasicInformation(companyId));
    }
}

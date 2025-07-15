package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.models.general.report.CompanyInformation;
import com.sico.api.checkinline.infraestructure.gateways.CompanyInformationGateway;
import com.sico.api.checkinline.infraestructure.mappers.CompanyInformationMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyInformationGatewayImpl implements CompanyInformationGateway {
    private final JpaCompanyInformationRepository repository;
    private final CompanyInformationMapper mapper;

    @Override
    public CompanyInformation companyInformation(String companyId, String tuition) {
        return mapper.toDto(repository.companyInformation(companyId, tuition));
    }
}

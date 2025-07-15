package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationOCGateway;
import com.sico.api.checkinline.infraestructure.mappers.CompanyBasicInformationOCMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyBasicInformationOCGatewayImpl implements CompanyBasicInformationOCGateway {

    private final JpaCompanyBasicInformationOCRepository repository;
    private final CompanyBasicInformationOCMapper mapper;

    @Override
    public CompanyBasicInformationOC getInformationByIdentificationAndRegister(String identification, String register) {
        return mapper.toDto(repository.findByIdentificationAndRegisteredId(identification, register));
    }
}

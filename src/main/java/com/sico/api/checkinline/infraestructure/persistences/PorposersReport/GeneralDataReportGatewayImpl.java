package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.models.Proposers.GeneralDataReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.GeneralDataReportGateway;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.GeneralDataReportMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralDataReportGatewayImpl implements GeneralDataReportGateway {

    private final JpaGeneralDataReportRepository repository;
    private final GeneralDataReportMapper mapper;

    @Override
    public GeneralDataReport consultGeneralData(String id) {
        return mapper.toDto(repository.consultGeneralData(id));
    }
}

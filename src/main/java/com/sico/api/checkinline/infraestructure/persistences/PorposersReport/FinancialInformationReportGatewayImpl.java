package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.models.Proposers.FinancialInformationReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.FinancialInformationReportGateway;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.FinancialInformationReportMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FinancialInformationReportGatewayImpl implements FinancialInformationReportGateway {

    private final JpaFinancialInformationReportRepository repository;
    private final FinancialInformationReportMapper mapper;

    @Override
    public FinancialInformationReport consultFinancialInformation(String id) {
        return mapper.toDto(repository.consultFinancialInformation(id));
    }
}

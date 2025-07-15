package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.models.Proposers.FinancialCapacityReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.FinancialCapacityReportGateway;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.FinancialCapacityReportMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FinancialCapacityReportGatewayImpl implements FinancialCapacityReportGateway {

    private final JpaFinancialCapacityReportRepository repository;
    private final FinancialCapacityReportMapper mapper;

    @Override
    public FinancialCapacityReport consultFinancialCapacity(String id) {
        return mapper.toDto(repository.consultFinancialCapacity(id));
    }
}

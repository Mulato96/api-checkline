package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.models.Proposers.ClasificationReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.ClasificationReportGateway;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.ClasificationReportMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClasificationReportGatewayImpl implements ClasificationReportGateway {

    private final JpaClasificationReportRepository repository;
    private final ClasificationReportMapper mapper;

    @Override
    public List<ClasificationReport> consultClasification(String id) {
        return mapper.toDto(repository.consultClasification(id));
    }
}

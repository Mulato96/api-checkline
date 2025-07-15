package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.models.Proposers.ExperienceReport;
import com.sico.api.checkinline.infraestructure.gateways.ProposersReport.ExperienceReportGateway;
import com.sico.api.checkinline.infraestructure.mappers.Proposers.ExperienceReportMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExperienceReportGatewayImpl implements ExperienceReportGateway {

    private final JpaExperienceReportRepository repository;
    private final ExperienceReportMapper mapper;
    @Override
    public List<ExperienceReport>  consultExperience(String id) {
        return mapper.toDto(repository.consultExperience(id));
    }
}

package com.sico.api.checkinline.infraestructure.gateways.ProposersReport;

import com.sico.api.checkinline.domain.models.Proposers.ExperienceReport;

import java.util.List;

public interface ExperienceReportGateway {
    List<ExperienceReport>  consultExperience(String id);
}

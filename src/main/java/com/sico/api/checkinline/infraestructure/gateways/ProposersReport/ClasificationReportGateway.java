package com.sico.api.checkinline.infraestructure.gateways.ProposersReport;

import com.sico.api.checkinline.domain.models.Proposers.ClasificationReport;

import java.util.List;

public interface ClasificationReportGateway {
    List<ClasificationReport>  consultClasification(String id);
}

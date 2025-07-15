package com.sico.api.checkinline.infraestructure.gateways.ProposersReport;

import com.sico.api.checkinline.domain.models.Proposers.GeneralDataReport;

public interface GeneralDataReportGateway {
    GeneralDataReport consultGeneralData(String id);
}

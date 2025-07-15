package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.Linked;

import java.util.List;

public interface LinkedGateway {

    List<Linked> checkOutLinkeds(String companyId, Boolean isBogota);
}

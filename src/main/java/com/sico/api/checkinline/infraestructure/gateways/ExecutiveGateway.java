package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.Executive;

import java.util.List;

public interface ExecutiveGateway {

    List<Executive> checkOutExecutives(String companyId, Boolean isBogota);
}

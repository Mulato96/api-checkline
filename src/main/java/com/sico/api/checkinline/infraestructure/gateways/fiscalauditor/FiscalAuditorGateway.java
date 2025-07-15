package com.sico.api.checkinline.infraestructure.gateways.fiscalauditor;

import com.sico.api.checkinline.domain.models.fiscalauditor.FiscalAuditor;

import java.util.List;

public interface FiscalAuditorGateway {
    List<FiscalAuditor>  getFiscalAuditorData(Long clientId, Long registeredId);
}

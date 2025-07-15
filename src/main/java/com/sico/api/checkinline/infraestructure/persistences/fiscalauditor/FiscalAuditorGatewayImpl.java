package com.sico.api.checkinline.infraestructure.persistences.fiscalauditor;

import com.sico.api.checkinline.domain.models.fiscalauditor.FiscalAuditor;
import com.sico.api.checkinline.infraestructure.gateways.fiscalauditor.FiscalAuditorGateway;
import com.sico.api.checkinline.infraestructure.mappers.fiscalauditor.FiscalAuditorMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FiscalAuditorGatewayImpl implements FiscalAuditorGateway {

    private final JpaFiscalAuditorRepository repository;
    private final FiscalAuditorMapper mapper;

    @Override
    public List<FiscalAuditor> getFiscalAuditorData(Long clientId, Long registeredId) {
        return mapper.toDto(repository.getFiscalAuditorData(clientId,registeredId));
    }
}

package com.sico.api.checkinline.infraestructure.persistences.ImporterExporter;

import com.sico.api.checkinline.domain.entities.ImporterExporter.ImportExportEntity;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ImportGateway;
import com.sico.api.checkinline.infraestructure.mappers.ImporterExporter.ImportExportMapper;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class ImportGatewayImpl implements ImportGateway {
    private final JpaImportRepository repository;
    private final ImportExportMapper mapper;
    @Override
    public List<ImportExport> consultImportData(String idClient, Date currentDate) {
        return mapper.toDto(repository.consultImportData(idClient, currentDate));
    }
}

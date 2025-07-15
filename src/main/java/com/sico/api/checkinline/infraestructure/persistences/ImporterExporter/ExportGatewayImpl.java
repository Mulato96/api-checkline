package com.sico.api.checkinline.infraestructure.persistences.ImporterExporter;

import com.sico.api.checkinline.domain.entities.ImporterExporter.ImportExportEntity;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ExportGateway;
import com.sico.api.checkinline.infraestructure.mappers.ImporterExporter.ImportExportMapper;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class ExportGatewayImpl implements ExportGateway{
    private final JpaExportRepository repository;
    private final ImportExportMapper mapper;
    @Override
    public List<ImportExport> consultExportData(String idClient, Date currentDate) {
        return mapper.toDto(repository.consultExportData(idClient, currentDate));
    }
}

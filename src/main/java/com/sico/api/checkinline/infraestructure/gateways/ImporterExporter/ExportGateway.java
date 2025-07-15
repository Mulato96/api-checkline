package com.sico.api.checkinline.infraestructure.gateways.ImporterExporter;

import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;

import java.util.Date;
import java.util.List;

public interface ExportGateway {
    List<ImportExport> consultExportData(String idClient, Date currentDate);
}

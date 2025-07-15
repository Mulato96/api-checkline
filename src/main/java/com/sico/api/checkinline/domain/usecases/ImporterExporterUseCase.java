package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImporterExporterReport;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ExportGateway;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ImportGateway;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
public class ImporterExporterUseCase {
    private final ImportGateway importGateway;
    private final ExportGateway exportGateway;
    private Date currentDate = new Date();

    public ImporterExporterReport consultImportExportData(String idCliente) {
       return ImporterExporterReport.builder()
               .importer(importGateway.consultImportData(idCliente, currentDate))
               .exporter(exportGateway.consultExportData(idCliente, currentDate))
               .build();
    }

    public boolean consultImpoterExporter(String idCliente){
        List<ImportExport> imports = importGateway.consultImportData(idCliente, currentDate);
        List<ImportExport> exports = exportGateway.consultExportData(idCliente, currentDate);
        if (imports.isEmpty() && exports.isEmpty()) {
            return false;
        }
        return true;
    }
}

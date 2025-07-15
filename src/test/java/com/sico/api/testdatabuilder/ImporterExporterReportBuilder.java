package com.sico.api.testdatabuilder;

import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImporterExporterReport;

import java.util.List;

public class ImporterExporterReportBuilder {
    private List<ImportExport> importerReport;

    private List<ImportExport> exporterReport;

    public ImporterExporterReportBuilder withImporter(List<ImportExport> importerReport){
        this.importerReport = importerReport;
        return  this;
    }

    public ImporterExporterReportBuilder withExporter(List<ImportExport> exporterReport){
        this.exporterReport = exporterReport;
        return  this;
    }

    public ImporterExporterReport build() {
        return new ImporterExporterReport(
                importerReport,
                exporterReport
        );
    }

    public static ImporterExporterReportBuilder anImporterExporterReport() {
        return new ImporterExporterReportBuilder();
    }
}

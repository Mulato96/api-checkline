package com.sico.api.checkinline.domain.models.ImporterExporter;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImporterExporterReport {

  private List<ImportExport> importer;
  private List<ImportExport> exporter;
}

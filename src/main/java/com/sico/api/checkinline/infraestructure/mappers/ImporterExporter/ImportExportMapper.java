package com.sico.api.checkinline.infraestructure.mappers.ImporterExporter;

import com.sico.api.checkinline.domain.entities.ImporterExporter.ImportExportEntity;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.infraestructure.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImportExportMapper extends EntityMapper<ImportExport, ImportExportEntity> {

}

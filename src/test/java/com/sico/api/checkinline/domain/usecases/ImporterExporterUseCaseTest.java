package com.sico.api.checkinline.domain.usecases;

import java.util.Calendar;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImportExport;
import com.sico.api.checkinline.domain.models.ImporterExporter.ImporterExporterReport;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ExportGateway;
import com.sico.api.checkinline.infraestructure.gateways.ImporterExporter.ImportGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImporterExporterUseCaseTest {

    @Mock
    private ExportGateway exportGateway;
    @Mock
    private ImportGateway importGateway;

    @InjectMocks
    private ImporterExporterUseCase importerExporterUseCase;

    @Test
    void testConsultExportData() {
        String idCliente = "8604018268";
        List<ImportExport> ImportExport = List.of(new ImportExport());

        //when
        doReturn(ImportExport).when(importGateway).consultImportData(eq(idCliente), any(Date.class));
        doReturn(ImportExport).when(exportGateway).consultExportData(eq(idCliente), any(Date.class));


        ImporterExporterReport data = this.importerExporterUseCase.consultImportExportData(idCliente);

        // Assert

        verify(importGateway, times(1)).consultImportData(eq(idCliente), any(Date.class));
        verify(exportGateway, times(1)).consultExportData(eq(idCliente), any(Date.class));
        assertNotNull(data);
    }
}
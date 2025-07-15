package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.usecases.ImporterExporterUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/import-export")
public class ImporterExporterRestController {
    private final ImporterExporterUseCase useCase;
    private final MessageTranslator message;

    @GetMapping("/{idCliente}")
    public ResponseEntity<Success> exportData(@Valid @PathVariable String idCliente) {
        return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{idCliente}),useCase.consultImportExportData(idCliente)));
    }
}

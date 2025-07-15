package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.usecases.FiscalAuditorUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fiscal-auditor")
@RequiredArgsConstructor
public class FiscalAuditorRestController {

    private final MessageTranslator message;
    private final FiscalAuditorUseCase useCase;

    @GetMapping("/{companyId}")
    public ResponseEntity<Success> getInformationData(@Valid @PathVariable Long companyId) {
        return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{companyId}),
                useCase.getFiscalAuditorData(companyId)));
    }

}

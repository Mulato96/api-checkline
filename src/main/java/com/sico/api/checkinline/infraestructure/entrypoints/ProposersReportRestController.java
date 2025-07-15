package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.usecases.ProposerReportUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proposers-report")
@RequiredArgsConstructor
public class ProposersReportRestController {

    private final ProposerReportUseCase usecase;
    private final MessageTranslator message;

    @GetMapping("/{id}")
    public ResponseEntity<Success>  consultReportInformation(@Valid @PathVariable String id){
        return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{id}),
                usecase.consultReportInformation(id)));
    }
}

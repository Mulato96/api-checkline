package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.usecases.LegalRepresentationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("legal-existence")
@RequiredArgsConstructor
public class LegalRepresentationController {

    private final LegalRepresentationUseCase usecase;
    private final MessageTranslator message;

    @GetMapping("/{id}/{isBogota}/{numMatricula}")
    public ResponseEntity<Success> consultCertificas(@Valid @PathVariable String id,@Valid @PathVariable Boolean isBogota, @Valid @PathVariable String numMatricula){
        return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{id}),
                usecase.consultCertificas(id, isBogota, numMatricula)));
    }
}

package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.domain.usecases.LinkedVerificationUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("linked-verification")
@RequiredArgsConstructor
@Validated
public class LinkedVerificationController {

    private final LinkedVerificationUseCase usecase;

    /**
     * Endpoint para obtener las verificaciones vinculadas.
     * Valida que los parámetros no sean nulos ni vacíos.
     *
     * @param identificationType Tipo de identificación (obligatorio, no nulo ni vacío).
     * @param identificationNumber Número de identificación (obligatorio, no nulo ni vacío).
     * @return Lista de verificaciones vinculadas.
     */
    @GetMapping()
    public ResponseEntity<List<LinkedVerification>> getLinkedVerifications(
            @NotBlank(message = "identificationType is required") @RequestParam(value = "identificationType") String identificationType,
            @NotBlank(message = "identificationNumber is required") @RequestParam(value = "identificationNumber") String identificationNumber) {

        List<LinkedVerification> verifications = usecase.getLinkedVerifications(identificationType, identificationNumber);

        return ResponseEntity.ok(verifications);
    }

}

package com.sico.api.checkinline.infraestructure.entrypoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sico.api.checkinline.domain.usecases.FinancialReportUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("financial-report")
@RequiredArgsConstructor
public class FinancialReportController {

    private final FinancialReportUseCase usesCase;

    @GetMapping
    public ResponseEntity<?> getFinancialReport(@Valid @RequestParam ("isBogota") Boolean isBogota,
            @Valid @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
            @RequestParam(value = "chamberId", required = false) Integer chamberId,
            @RequestParam(value = "registered", required = false) String registered) {

        return ResponseEntity.ok(usesCase.getFinancialReportList(isBogota, registrationNumber, chamberId, registered));
    }
}

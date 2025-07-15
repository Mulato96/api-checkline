package com.sico.api.checkinline.infraestructure.entrypoints.naturalpersonregistration;

import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.domain.usecases.naturalpersonregistration.NaturalPersonRegistrationUseCase;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("natural-person-registration")
@RequiredArgsConstructor
@Validated
public class NaturalPersonRegistrationRestController {

    private final NaturalPersonRegistrationUseCase usecase;

    @GetMapping()
    public ResponseEntity<List<NaturalPersonRegistration>> getNaturalPersonRegistration(
            @NotBlank(message = "registrationNumber is required") @RequestParam(value = "registrationNumber") String registrationNumber,
            @NotBlank(message = "chamberId is required") @RequestParam(value = "chamberId") String chamberId
            ) {

        List<NaturalPersonRegistration> naturalPersonRegistration = usecase.getNaturalPersonRegistration(registrationNumber,chamberId);

        return ResponseEntity.ok(naturalPersonRegistration);
    }
}

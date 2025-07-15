package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.usecases.CheckOutInformationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("information")
@RequiredArgsConstructor
public class CheckOutInformationRestController {

  private final CheckOutInformationUseCase useCase;
  private final MessageTranslator message;

  @GetMapping("/company/{companyId}/is-bogota/{isBogota}")
  public ResponseEntity<Success> getInformation(@Valid @PathVariable String companyId, @PathVariable Boolean isBogota) {
    return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{companyId}),
        useCase.checkOutInformationReport(companyId, isBogota)));
  }

  @GetMapping("/document-number/{documentNumber}/tuition/{tuition}")
  public ResponseEntity<Success> getInformation(@Valid @PathVariable String documentNumber, @PathVariable String tuition) {
    return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{documentNumber}),
        useCase.checkOutCompanyInformationReport(documentNumber, tuition)));
  }

  @GetMapping("/company/basic-data/{companyId}/{isBogota}")
  public ResponseEntity<Success> getInformationData(@Valid @PathVariable String companyId, @PathVariable Boolean isBogota) {
    return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{companyId}),
            useCase.checkOutCompanyBasicData(companyId, isBogota)));
  }
}

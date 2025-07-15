package com.sico.api.checkinline.infraestructure.entrypoints.laft.verification;

import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.PATH_TEMPLATE_LAFT_BULK;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sico.api.checkinline.application.components.VerificationLaftExcelValidatorComponent;
import com.sico.api.checkinline.domain.models.VerificationLaftParameters;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestPayload;
import com.sico.api.checkinline.domain.models.laft.verification.ValidateLaftResponse;
import com.sico.api.checkinline.domain.usecases.laft.GenerateLaftRequestUseCase;
import com.sico.api.checkinline.domain.usecases.laft.GetParametersVerificationLaftUseCase;
import com.sico.api.checkinline.domain.usecases.laft.ValidateVerificationLaftUseCase;
import com.sico.api.checkinline.infraestructure.builder.ExcelBuilder;
import com.sico.api.checkinline.infraestructure.utils.Logging;
import java.io.IOException;
import java.net.URLConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/verification-laft")
@RequiredArgsConstructor
public class VerificationLaftController {

  private final VerificationLaftExcelValidatorComponent validator;
  private final ExcelBuilder excelBuilder;
  private final GenerateLaftRequestUseCase generateLaftRequestUseCase;
  private final ValidateVerificationLaftUseCase validateVerificationLaftUseCase;
  private final GetParametersVerificationLaftUseCase getParametersVerificationLaftUseCase;

  @GetMapping("/parameters")
  public ResponseEntity<VerificationLaftParameters> getParameters() {
    return ResponseEntity.ok().body(getParametersVerificationLaftUseCase.getParameters());
  }

  @GetMapping("/template/download")
  public ResponseEntity<Resource> downloadFile() throws IOException {
    Resource resource = new ClassPathResource(PATH_TEMPLATE_LAFT_BULK);
    if (!resource.exists()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION,
        String.format("attachment; filename=%s", resource.getFilename()));
    String mimeType = URLConnection.guessContentTypeFromStream(resource.getInputStream());
    headers.add(HttpHeaders.CONTENT_TYPE, mimeType != null ? mimeType : "application/octet-stream");
    return ResponseEntity.ok()
        .headers(headers)
        .body(resource);
  }

  @Logging
  @PostMapping("/bulk-upload/validate")
  public ResponseEntity<ValidateLaftResponse> validateFileUpload(
      @RequestParam("template") MultipartFile template) throws IOException {
    validator.validate(template);
    return ResponseEntity.ok()
        .body(validateVerificationLaftUseCase.validateRequest(
            excelBuilder.extractData(template, new TypeReference<>() {
            })));
  }

  @Logging
  @PostMapping("/generate-request")
  public ResponseEntity<Void> generateRequest(
      @RequestBody LaftRequestPayload request) {
    ValidateLaftResponse validateLaftResponse = validateVerificationLaftUseCase.validatePreGenerate(
        request);
    generateLaftRequestUseCase.generate(validateLaftResponse.requestSuccess(), request.IdMailBox());
    return ResponseEntity.ok().build();
  }
}

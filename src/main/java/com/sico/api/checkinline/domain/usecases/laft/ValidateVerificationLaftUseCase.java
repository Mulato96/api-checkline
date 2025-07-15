package com.sico.api.checkinline.domain.usecases.laft;

import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_CONTENT_ERROR;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_CONTENT_LIMITED_SURPASSED;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.NUMBER_VALID_CHARACTERS;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.application.exceptions.VerificationLaftException;
import com.sico.api.checkinline.application.properties.VerificationLaftProperties;
import com.sico.api.checkinline.domain.models.identificationtype.IdentificationType;
import com.sico.api.checkinline.domain.models.identificationtype.IdentificationTypeShort;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestPayload;
import com.sico.api.checkinline.domain.models.laft.verification.ValidateLaftResponse;
import com.sico.api.checkinline.domain.models.laft.verification.VerificationLaftRequest;
import com.sico.api.checkinline.domain.models.laft.verification.VerificationLaftResponse;
import com.sico.api.checkinline.domain.port.driver.IdentificationTypeGateway;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateVerificationLaftUseCase {

  private final VerificationLaftProperties verificationLaftProperties;
  private final MessageTranslator messageTranslator;
  private final IdentificationTypeGateway identificationTypeGateway;

  public ValidateLaftResponse validateRequest(List<VerificationLaftRequest> requests) {
    validateLimitedMaxByRequest(requests);
    List<IdentificationType> identificationTypes = identificationTypeGateway.findAll().stream()
        .filter(value -> nonNull(value.getUseLaft()) && value.getUseLaft()).toList();
    requests.forEach(
        verificationLaftRequest -> validate(verificationLaftRequest, identificationTypes));
    validateDuplicate(requests);
    return ValidateLaftResponse.builder()
        .requestError(
            requests.stream().filter(request -> !request.getCheckedErrors().isEmpty())
                .map(this::buildVerificationLaftResponse).toList())
        .requestSuccess(
            requests.stream().filter(request -> request.getCheckedErrors().isEmpty())
                .map(this::buildVerificationLaftResponse).toList())
        .build();
  }

  private VerificationLaftResponse buildVerificationLaftResponse(VerificationLaftRequest request) {
    return VerificationLaftResponse.builder()
        .natureLegalLabel(request.getNatureLegalLabel())
        .identificationTypeLabel(request.getIdentificationTypeLabel())
        .identificationNumber(request.getIdentificationNumber())
        .companyName(request.getCompanyName())
        .identificationType(request.getIdentificationType())
        .build();
  }

  public ValidateLaftResponse validatePreGenerate(LaftRequestPayload payload) {
    List<VerificationLaftRequest> requestsValidate = payload.laftRequestInfoList().stream()
        .map(value -> VerificationLaftRequest.builder()
            .companyName(value.companyName())
            .identificationType(
                isNull(value.identificationType()) ? null : value.identificationType().name())
            .identificationNumber(value.identificationNumber())
            .build()).toList();
    ValidateLaftResponse verificationLaftResponse = validateRequest(requestsValidate);
    if (!verificationLaftResponse.requestError().isEmpty()) {
      throw new VerificationLaftException(EXCEPTION_CONTENT_ERROR);
    }
    return verificationLaftResponse;
  }

  private void validate(VerificationLaftRequest request,
      List<IdentificationType> identificationTypes) {
    request.setCheckedErrors(new ArrayList<>());
    if (isNullOrEmpty(request.getCompanyName())) {
      validateIdentificationTypeAndIdentificationNumb(request, identificationTypes);
    } else {
      if (request.getCompanyName().length() < NUMBER_VALID_CHARACTERS || !isAlphanumericWithSpace(
          request.getCompanyName())) {
        request.getCheckedErrors().add(false);
      }
      boolean hasIdentificationTypeAndNumber =
          !isNullOrEmpty(request.getIdentificationType()) || !isNullOrEmpty(
              request.getIdentificationNumber());
      if (hasIdentificationTypeAndNumber) {
        validateIdentificationTypeAndIdentificationNumb(request, identificationTypes);
      }
    }
  }

  private void validateLimitedMaxByRequest(List<VerificationLaftRequest> request) {
    if (request.size() > verificationLaftProperties.getLimitMaxRequestByBulkUpload()) {
      throw new VerificationLaftException(
          String.format(messageTranslator.getMessage(EXCEPTION_TEMPLATE_CONTENT_LIMITED_SURPASSED),
              verificationLaftProperties.getLimitMaxRequestByBulkUpload()));
    }
  }

  private void validateIdentificationTypeAndIdentificationNumb(VerificationLaftRequest request,
      List<IdentificationType> identificationTypes) {
    IdentificationTypeShort identificationTypeShort = request.getIdentificationTypeShort();
    if (!isNull(identificationTypeShort) && !isNullOrEmpty(
        request.getIdentificationNumber())) {
      if (request.getIdentificationNumber().length() < NUMBER_VALID_CHARACTERS) {
        request.getCheckedErrors().add(false);
      } else {
        Optional<IdentificationType> identificationTypeOptional = identificationTypes.stream()
            .filter(
                value -> value.getIdentificationTypeShort() == identificationTypeShort).findFirst();
        identificationTypeOptional.ifPresentOrElse(value -> {
          request.setIdentificationTypeLabel(value.getLabelLaft());
          request.setNatureLegalLabel(value.getLegalNature());
        }, () -> request.getCheckedErrors().add(false));
      }
    } else {
      request.getCheckedErrors().add(false);
    }
  }

  private boolean isNullOrEmpty(String value) {
    return isNull(value) || value.isBlank();
  }

  private boolean isAlphanumericWithSpace(String value) {
    return value.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$");
  }

  private void validateDuplicate(List<VerificationLaftRequest> requests){
    Map<String, VerificationLaftRequest> requestMap = new HashMap<>();
    requests.forEach(request -> {
      String key = request.getIdentificationType() + request.getIdentificationNumber() + request.getCompanyName();
      if (!requestMap.containsKey(key)){
        requestMap.put(key, request);
      }else{
        if (isNull(request.getCheckedErrors()) || request.getCheckedErrors().isEmpty()){
          request.setCheckedErrors(List.of(true));
        }else{
          request.getCheckedErrors().add(false);;
        }
      }
    });
  }

}

package com.sico.api.checkinline.domain.usecases.laft;

import com.sico.api.checkinline.application.properties.VerificationLaftProperties;
import com.sico.api.checkinline.domain.models.VerificationLaftParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetParametersVerificationLaftUseCase {

  private final VerificationLaftProperties properties;

  public VerificationLaftParameters getParameters(){
    return VerificationLaftParameters.builder()
        .sizeMaxPermitted(properties.getSizeBulkUpload())
        .limitMaxPerRequest(properties.getLimitMaxRequestByBulkUpload())
        .creditValueByRequest(properties.getCreditValueByRequest())
        .processedTimeRequest(properties.getTimeInHour())
        .build();
  }
}

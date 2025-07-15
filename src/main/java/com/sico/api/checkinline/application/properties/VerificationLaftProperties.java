package com.sico.api.checkinline.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = VerificationLaftProperties.PREFIX)
@Validated
@Getter
@Setter
public class VerificationLaftProperties {

  public static final String PREFIX = "app.laft.verification";

  private Integer creditValueByRequest;
  private Integer timeInHour;
  private Integer limitMaxRequestByBulkUpload;
  private Long sizeBulkUpload;
}

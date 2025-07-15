package com.sico.api.checkinline.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = AppProperties.PREFIX)
@Validated
@Getter
@Setter
public class AppProperties {

  public static final String PREFIX = "app.employees.calculation";

  private Integer years;
}

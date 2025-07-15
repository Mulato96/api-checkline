package com.sico.api.checkinline.application.configs;

import com.sico.api.checkinline.infraestructure.entrypoints.CheckOutCompanySearchRestController;
import com.sico.api.checkinline.infraestructure.entrypoints.CheckOutInformationRestController;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore({ValidationAutoConfiguration.class})
@ComponentScan(
    basePackageClasses = {CheckOutInformationRestController.class, CheckOutCompanySearchRestController.class}
)
@Log4j2
public class RestAutoConfig {

  public RestAutoConfig() {
    log.info("..::Starting RestController Configuration::..");
  }
}

package com.sico.api.checkinline.infraestructure.external.rest;

import com.sico.api.checkinline.application.properties.LaftApiProperties;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestExternal;
import com.sico.api.checkinline.domain.port.driver.laftverification.LaftVerificationGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class LaftVerificationGatewayImpl implements LaftVerificationGateway {

  private final WebClient webClient;
  private final LaftApiProperties properties;

  @Override
  public void createRequest(LaftRequestExternal laftRequestExternal) {
    webClient.post()
        .uri(String.format("%s%s",properties.getUrlBase(), properties.getPath()))
        .bodyValue(laftRequestExternal)
        .retrieve()
        .bodyToMono(Void.class)
        .block();
  }
}

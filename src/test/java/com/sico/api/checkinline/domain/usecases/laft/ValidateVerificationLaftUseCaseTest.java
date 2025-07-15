package com.sico.api.checkinline.domain.usecases.laft;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.application.exceptions.VerificationLaftException;
import com.sico.api.checkinline.application.properties.VerificationLaftProperties;
import com.sico.api.checkinline.domain.models.identificationtype.IdentificationType;
import com.sico.api.checkinline.domain.models.identificationtype.IdentificationTypeShort;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestInfo;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestPayload;
import com.sico.api.checkinline.domain.models.laft.verification.ValidateLaftResponse;
import com.sico.api.checkinline.domain.models.laft.verification.VerificationLaftRequest;
import com.sico.api.checkinline.domain.port.driver.IdentificationTypeGateway;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.TestPropertySource;


@TestPropertySource(properties = {
    "app.laft.verification.credit-value-by-request=${CREDIT_VALUE_QUERY:100}",
    "app.laft.verification.time-in-hour=${TIME_PROCESSED_QUERY_LAFT:1}",
    "app.laft.verification.limit-max-request-by-bulk-upload=${LIMIT_MAXIMUM_PERMITTED_REQUEST_QUERY_LAFT:200}",
    "app.laft.verification.size-bulk-upload=${SIZE_PERMITTED_BULK_UPLOAD:2}"
})
class ValidateVerificationLaftUseCaseTest {

  @Mock
  private VerificationLaftProperties verificationLaftProperties;

  @Mock
  private MessageTranslator messageTranslator;

  @Mock
  private IdentificationTypeGateway identificationTypeGateway;

  @InjectMocks
  private ValidateVerificationLaftUseCase validateVerificationLaftUseCase;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void validateRequest_WhenRequestsExceedLimit_ShouldThrowException() {
    // Arrange
    List<VerificationLaftRequest> requests = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      requests.add(new VerificationLaftRequest());
    }
    when(verificationLaftProperties.getLimitMaxRequestByBulkUpload()).thenReturn(10);
    when(messageTranslator.getMessage(anyString())).thenReturn("Limit exceeded: %s");

    // Act & Assert
    VerificationLaftException exception = assertThrows(VerificationLaftException.class, () ->
        validateVerificationLaftUseCase.validateRequest(requests)
    );
    assertEquals("Limit exceeded: 10", exception.getReason());
  }

  @Test
  void validateRequest_WhenValidRequests_ShouldReturnCorrectResponse() {
    // Arrange
    VerificationLaftRequest validRequest = new VerificationLaftRequest();
    validRequest.setCompanyName("Valid Company");
    validRequest.setIdentificationType("CC");
    validRequest.setIdentificationNumber("123456789");

    List<VerificationLaftRequest> requests = Collections.singletonList(validRequest);
    when(verificationLaftProperties.getLimitMaxRequestByBulkUpload()).thenReturn(10);
    when(identificationTypeGateway.findAll()).thenReturn(Collections.singletonList(
        new IdentificationType("1", "CC", "CC", "lable", "naturelegal", true)));

    // Act
    ValidateLaftResponse response = validateVerificationLaftUseCase.validateRequest(requests);

    // Assert
    assertNotNull(response);
    assertTrue(!response.requestSuccess().isEmpty());
    assertTrue(response.requestError().isEmpty());
  }

  @Test
  void validateRequest_WhenValidRequests_ShouldReturnCustomResponse() {
    // Arrange
    List<VerificationLaftRequest> requests = getData();

    when(verificationLaftProperties.getLimitMaxRequestByBulkUpload()).thenReturn(10);
    when(identificationTypeGateway.findAll()).thenReturn(Collections.singletonList(
        new IdentificationType("1", "CC", "CC", "lable", "naturelegal", true)));

    // Act
    ValidateLaftResponse response = validateVerificationLaftUseCase.validateRequest(requests);

    // Assert
    assertNotNull(response);
    assertFalse(response.requestSuccess().isEmpty());
    assertFalse(response.requestError().isEmpty());
  }

  @Test
  void validateRequest_WhenInvalidRequests_ShouldReturnErrors() {
    // Arrange
    VerificationLaftRequest invalidRequest = new VerificationLaftRequest();
    invalidRequest.setCompanyName("");

    List<VerificationLaftRequest> requests = Collections.singletonList(invalidRequest);
    when(verificationLaftProperties.getLimitMaxRequestByBulkUpload()).thenReturn(10);
    when(identificationTypeGateway.findAll()).thenReturn(Collections.emptyList());

    // Act
    ValidateLaftResponse response = validateVerificationLaftUseCase.validateRequest(requests);

    // Assert
    assertNotNull(response);
    assertTrue(!response.requestError().isEmpty());
    assertTrue(response.requestSuccess().isEmpty());
  }

  private List<VerificationLaftRequest> getData() {
    return List.of(
        VerificationLaftRequest.builder().identificationType("CC").identificationNumber("099080980")
            .build(),
        VerificationLaftRequest.builder().identificationType("CE").identificationNumber("231")
            .build(),
        VerificationLaftRequest.builder().identificationType("2").build(),
        VerificationLaftRequest.builder().build(),
        VerificationLaftRequest.builder().companyName("cv").build(),
        VerificationLaftRequest.builder().identificationNumber("3444545").build(),
        VerificationLaftRequest.builder().identificationNumber("2343432").identificationType("2")
            .companyName("Camara").build()
    );
  }

  @Test
  void shouldValidatePreGenerateSuccessfully() {
    LaftRequestInfo laftRequestInfo = new LaftRequestInfo(
        IdentificationTypeShort.CC, "CC", "Natural", "123456", "Test Company"
    );

    List<VerificationLaftRequest> request = List.of(VerificationLaftRequest.builder()
            .companyName("Test Company")
            .identificationNumber("123456")
            .identificationType(IdentificationTypeShort.CC.name())
            .identificationTypeLabel("Natural")
        .build());
    LaftRequestPayload payload = new LaftRequestPayload(List.of(laftRequestInfo), 123L);

    when(verificationLaftProperties.getLimitMaxRequestByBulkUpload()).thenReturn(10);
    when(identificationTypeGateway.findAll()).thenReturn(Collections.singletonList(
        new IdentificationType("1", "CC", "CC", "lable", "naturelegal", true)));

    ValidateLaftResponse mockResponse = validateVerificationLaftUseCase.validateRequest(request);
    assertDoesNotThrow(() -> validateVerificationLaftUseCase.validatePreGenerate(payload));
    assertNotNull(mockResponse);
  }
}
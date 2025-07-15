package com.sico.api.checkinline.domain.usecases.laft;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.sico.api.checkinline.application.properties.VerificationLaftProperties;
import com.sico.api.checkinline.domain.models.VerificationLaftParameters;
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
class GetParametersVerificationLaftUseCaseTest {

  @Mock
  private VerificationLaftProperties properties;

  @InjectMocks
  private GetParametersVerificationLaftUseCase getParametersVerificationLaftUseCase;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getParameters_ShouldReturnCorrectParameters() {
    // Arrange
    when(properties.getSizeBulkUpload()).thenReturn(2L);
    when(properties.getLimitMaxRequestByBulkUpload()).thenReturn(10);
    when(properties.getCreditValueByRequest()).thenReturn(2);
    when(properties.getTimeInHour()).thenReturn(4);

    // Act
    VerificationLaftParameters parameters = getParametersVerificationLaftUseCase.getParameters();

    // Assert
    assertNotNull(parameters);
    assertEquals(2L, parameters.sizeMaxPermitted());
    assertEquals(10, parameters.limitMaxPerRequest());
    assertEquals(2, parameters.creditValueByRequest());
    assertEquals(4, parameters.processedTimeRequest());
  }
}
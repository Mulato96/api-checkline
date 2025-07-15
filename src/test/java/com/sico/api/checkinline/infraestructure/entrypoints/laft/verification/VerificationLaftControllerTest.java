package com.sico.api.checkinline.infraestructure.entrypoints.laft.verification;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sico.api.checkinline.application.components.VerificationLaftExcelValidatorComponent;
import com.sico.api.checkinline.domain.models.VerificationLaftParameters;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestInfo;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestPayload;
import com.sico.api.checkinline.domain.models.laft.verification.ValidateLaftResponse;
import com.sico.api.checkinline.domain.models.laft.verification.VerificationLaftResponse;
import com.sico.api.checkinline.domain.usecases.laft.GenerateLaftRequestUseCase;
import com.sico.api.checkinline.domain.usecases.laft.GetParametersVerificationLaftUseCase;
import com.sico.api.checkinline.domain.usecases.laft.ValidateVerificationLaftUseCase;
import com.sico.api.checkinline.infraestructure.builder.ExcelBuilder;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VerificationLaftControllerTest {

  @Mock
  private VerificationLaftExcelValidatorComponent validator;

  @Mock
  private ExcelBuilder excelBuilder;

  @Mock
  private ValidateVerificationLaftUseCase validateVerificationLaftUseCase;

  @Mock
  private GenerateLaftRequestUseCase generateLaftRequestUseCase;

  @Mock
  private GetParametersVerificationLaftUseCase getParametersVerificationLaftUseCase;

  @InjectMocks
  private VerificationLaftController verificationLaftController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getParameters_ShouldReturnParameters() {
    // Arrange
    VerificationLaftParameters expectedParameters = new VerificationLaftParameters(
        10, 2, 3, 1L);
    when(getParametersVerificationLaftUseCase.getParameters()).thenReturn(expectedParameters);

    // Act
    ResponseEntity<VerificationLaftParameters> response = verificationLaftController.getParameters();

    // Assert
    assertNotNull(response);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedParameters, response.getBody());
  }

  @Test
  void downloadFile_WhenFileExists_ShouldReturnFile() throws IOException {
    // Arrange
    Resource mockResource = mock(Resource.class);
    when(mockResource.exists()).thenReturn(true);
    when(mockResource.getFilename()).thenReturn("mock-file.xlsx");
    when(mockResource.getFile()).thenReturn(new File("mock-file.xlsx"));

    // Act
    ResponseEntity<Resource> response = verificationLaftController.downloadFile();

    // Assert
    assertNotNull(response);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertTrue(response.getHeaders().containsKey(HttpHeaders.CONTENT_DISPOSITION));
  }

  @Test
  void validateFileUpload_WhenValidFile_ShouldReturnValidationResponse() throws IOException {
    // Arrange
    MockMultipartFile mockFile = new MockMultipartFile("template", "file.xlsx",
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", new byte[0]);
    ValidateLaftResponse expectedResponse = new ValidateLaftResponse(List.of(), List.of());

    doNothing().when(validator).validate(mockFile);
    when(excelBuilder.extractData(eq(mockFile), any(TypeReference.class)))
        .thenReturn(Collections.emptyList());
    when(validateVerificationLaftUseCase.validateRequest(Collections.emptyList()))
        .thenReturn(expectedResponse);

    // Act
    ResponseEntity<ValidateLaftResponse> response = verificationLaftController.validateFileUpload(
        mockFile);

    // Assert
    assertNotNull(response);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedResponse, response.getBody());
  }

  @Test
  void shouldGenerateRequestSuccessfully()  {
    LaftRequestPayload requestPayload = new LaftRequestPayload(
        List.of(new LaftRequestInfo(null, "", "", "", "Camara")), 3256L);

    ValidateLaftResponse expectedResponse = new ValidateLaftResponse(List.of(VerificationLaftResponse.builder()
        .companyName("company")
        .build()), List.of());

    when(validateVerificationLaftUseCase.validatePreGenerate(requestPayload))
        .thenReturn(expectedResponse);
    doNothing().when(generateLaftRequestUseCase).generate(expectedResponse.requestSuccess(), requestPayload.IdMailBox());
    ResponseEntity<Void> response = verificationLaftController.generateRequest(requestPayload);

    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}
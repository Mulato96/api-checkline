package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.domain.usecases.LinkedVerificationUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LinkedVerificationControllerTest {

    private LinkedVerificationController controller;

    @Mock
    private LinkedVerificationUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new LinkedVerificationController(useCase);
    }

    @Test
    void getLinkedVerifications_ReturnsListOfVerifications_WhenParametersAreValid() {
        String identificationType = "CC";
        String identificationNumber = "12345678";

        List<LinkedVerification> mockVerifications = Arrays.asList(
                new LinkedVerification(),
                new LinkedVerification()
        );

        when(useCase.getLinkedVerifications(identificationType, identificationNumber)).thenReturn(mockVerifications);

        ResponseEntity<List<LinkedVerification>> response = controller.getLinkedVerifications(identificationType, identificationNumber);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());

        verify(useCase, times(1)).getLinkedVerifications(identificationType, identificationNumber);
    }

    @Test
    void getLinkedVerifications_ReturnsEmptyList_WhenNoDataFound() {
        String identificationType = "CC";
        String identificationNumber = "99999999";

        when(useCase.getLinkedVerifications(identificationType, identificationNumber)).thenReturn(List.of());

        ResponseEntity<List<LinkedVerification>> response = controller.getLinkedVerifications(identificationType, identificationNumber);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());

        verify(useCase, times(1)).getLinkedVerifications(identificationType, identificationNumber);
    }

    @Test
    void getLinkedVerifications_ThrowsException_WhenUseCaseFails() {
        String identificationType = "CC";
        String identificationNumber = "12345678";

        when(useCase.getLinkedVerifications(identificationType, identificationNumber))
                .thenThrow(new RuntimeException("Unexpected error"));

        try {
            controller.getLinkedVerifications(identificationType, identificationNumber);
        } catch (RuntimeException ex) {
            assertEquals("Unexpected error", ex.getMessage());
        }

        verify(useCase, times(1)).getLinkedVerifications(identificationType, identificationNumber);
    }
}

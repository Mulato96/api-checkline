package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.infraestructure.gateways.linkedverification.LinkedVerificationGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LinkedVerificationUseCaseTest {

    @Mock
    private LinkedVerificationGateway linkedVerificationGateway;

    private LinkedVerificationUseCase linkedVerificationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        linkedVerificationUseCase = new LinkedVerificationUseCase(linkedVerificationGateway);
    }

    @Test
    void getLinkedVerifications_shouldReturnLinkedVerifications() {
        String identificationType = "DNI";
        String identificationNumber = "12345";
        String expectedPaddedIdentificationNumber = "000000000012345";

        List<LinkedVerification> expectedResponse = Collections.singletonList(new LinkedVerification());

        when(linkedVerificationGateway.getLinkedVerification(identificationType, expectedPaddedIdentificationNumber))
                .thenReturn(expectedResponse);

        List<LinkedVerification> result = linkedVerificationUseCase.getLinkedVerifications(identificationType, identificationNumber);

        assertNotNull(result);
        assertEquals(expectedResponse, result);
        verify(linkedVerificationGateway, times(1)).getLinkedVerification(identificationType, expectedPaddedIdentificationNumber);
    }

}
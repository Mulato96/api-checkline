package com.sico.api.checkinline.domain.usecases.naturalpersonregistration;

import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.infraestructure.gateways.naturalpersonregistration.NaturalPersonRegistrationGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NaturalPersonRegistrationUseCaseTest {

    @Mock
    private NaturalPersonRegistrationGateway gateway;

    @InjectMocks
    private NaturalPersonRegistrationUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getNaturalPersonRegistration_ValidRegistrationNumber_ReturnsNaturalPersonRegistration() {

        String registrationNumber = "12345";
        String chamberId = "1";
        List<NaturalPersonRegistration> mockResponse = new ArrayList<>();

        when(gateway.getNaturalPersonRegistration(registrationNumber,chamberId)).thenReturn(mockResponse);

        List<NaturalPersonRegistration> result = useCase.getNaturalPersonRegistration(registrationNumber,chamberId);

        assertNotNull(result);
        assertEquals(mockResponse, result);
        verify(gateway, times(1)).getNaturalPersonRegistration(registrationNumber,chamberId);
    }

    @Test
    void getNaturalPersonRegistration_InvalidRegistrationNumber_ReturnsNull() {

        String registrationNumber = "67890";
        String chamberId = "1";

        when(gateway.getNaturalPersonRegistration(registrationNumber,chamberId)).thenReturn(null);

        List<NaturalPersonRegistration> result = useCase.getNaturalPersonRegistration(registrationNumber,chamberId);

        assertNull(result);
        verify(gateway, times(1)).getNaturalPersonRegistration(registrationNumber,chamberId);
    }
}
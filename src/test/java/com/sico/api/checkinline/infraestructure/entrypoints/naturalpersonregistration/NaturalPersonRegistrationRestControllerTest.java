package com.sico.api.checkinline.infraestructure.entrypoints.naturalpersonregistration;

import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.domain.usecases.naturalpersonregistration.NaturalPersonRegistrationUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NaturalPersonRegistrationRestControllerTest {

    @Mock
    private NaturalPersonRegistrationUseCase usecase;

    @InjectMocks
    private NaturalPersonRegistrationRestController controller;

    public NaturalPersonRegistrationRestControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getNaturalPersonRegistration_ValidRequest_ReturnsOkResponse() {

        String registrationNumber = "12345";
        String chamberId = "1";
        List<NaturalPersonRegistration> mockResponse = new ArrayList<>();
        when(usecase.getNaturalPersonRegistration(registrationNumber,chamberId)).thenReturn(mockResponse);

        ResponseEntity<List<NaturalPersonRegistration>> response = controller.getNaturalPersonRegistration(registrationNumber,chamberId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(usecase, times(1)).getNaturalPersonRegistration(registrationNumber,chamberId);
    }

}
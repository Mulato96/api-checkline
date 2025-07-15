package com.sico.api.checkinline.infraestructure.persistences.naturalpersonregistration;

import com.sico.api.checkinline.domain.entities.naturalpersonregistration.NaturalPersonRegistrationEntity;
import com.sico.api.checkinline.domain.models.naturalpersonregistration.NaturalPersonRegistration;
import com.sico.api.checkinline.infraestructure.mappers.naturalpersonregistration.NaturalPersonRegistrationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NaturalPersonRegistrationGatewayImplTest {

    @Mock
    private NaturalPersonRegistrationRepository repository;

    @Mock
    private NaturalPersonRegistrationMapper mapper;

    @InjectMocks
    private NaturalPersonRegistrationGatewayImpl gateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getNaturalPersonRegistration_FoundInPrimaryRepository_ReturnsMappedDto() {
        String registrationNumber = "12345";
        String chamberId = "1";
        List<NaturalPersonRegistrationEntity> mockEntity = new ArrayList<>();
        List<NaturalPersonRegistrationEntity> mockDto =  new ArrayList<>();

        when(repository.findNaturalPersonRegistration(registrationNumber)).thenReturn(mockEntity);

        List<NaturalPersonRegistration> result = gateway.getNaturalPersonRegistration(registrationNumber,chamberId);

        assertNotNull(result);
        verify(repository, times(1)).findNaturalPersonRegistration(registrationNumber);
        verify(mapper, times(1)).toDto(mockEntity);

    }


}

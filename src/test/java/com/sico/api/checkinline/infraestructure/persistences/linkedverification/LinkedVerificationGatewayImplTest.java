package com.sico.api.checkinline.infraestructure.persistences.linkedverification;

import com.sico.api.checkinline.domain.entities.linkedverification.LinkedVerificationEntity;
import com.sico.api.checkinline.domain.models.linkedverification.LinkedVerification;
import com.sico.api.checkinline.infraestructure.gateways.linkedverification.LinkedVerificationGateway;
import com.sico.api.checkinline.infraestructure.mappers.linkedverification.LinkedVerificationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LinkedVerificationGatewayImplTest {

    @Mock
    private LinkedVerificationRepository repository;

    @Mock
    private LinkedVerificationMapper mapper;

    private LinkedVerificationGateway gateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gateway = new LinkedVerificationGatewayImpl(repository, mapper);
    }

    @Test
    void getLinkedVerification_shouldReturnMappedLinkedVerifications() {
        String identificationType = "ID";
        String identificationNumber = "123456789";

        LinkedVerificationEntity entity1 = new LinkedVerificationEntity();
        entity1.setClientId(1L);

        LinkedVerificationEntity entity2 = new LinkedVerificationEntity();
        entity2.setClientId(2L);

        List<LinkedVerificationEntity> entities = Arrays.asList(entity1, entity2);

        LinkedVerification verification1 = new LinkedVerification();
        verification1.setClientId(1L);

        LinkedVerification verification2 = new LinkedVerification();
        verification2.setClientId(2L);

        List<LinkedVerification> expectedVerifications = Arrays.asList(verification1, verification2);

        when(repository.findLinkedVerification(identificationType, identificationNumber)).thenReturn(entities);
        when(mapper.toDto(entities)).thenReturn(expectedVerifications);

        List<LinkedVerification> result = gateway.getLinkedVerification(identificationType, identificationNumber);

        assertEquals(expectedVerifications, result);
        verify(repository, times(1)).findLinkedVerification(identificationType, identificationNumber);
        verify(mapper, times(1)).toDto(entities);
    }

    @Test
    void getLinkedVerification_shouldReturnEmptyListWhenNoEntitiesFound() {
        String identificationType = "ID";
        String identificationNumber = "000000000";

        when(repository.findLinkedVerification(identificationType, identificationNumber)).thenReturn(List.of());
        when(mapper.toDto(List.of())).thenReturn(List.of());

        List<LinkedVerification> result = gateway.getLinkedVerification(identificationType, identificationNumber);

        assertEquals(0, result.size());
        verify(repository, times(1)).findLinkedVerification(identificationType, identificationNumber);
        verify(mapper, times(1)).toDto(List.of());
    }

}
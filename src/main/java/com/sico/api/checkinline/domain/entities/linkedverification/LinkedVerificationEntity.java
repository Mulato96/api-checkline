package com.sico.api.checkinline.domain.entities.linkedverification;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class LinkedVerificationEntity implements Serializable {

    private Long clientId;

    private String clientIdentificationType;

    private String clientIdentification;

    private String clientName;

    @Id
    private Long employerClientId;

    private String employerIdentificationType;

    private String employerIdentificationTypeDescription;

    private String employerIdentification;

    private String employerName;

    private String status;

    private String societyType;

    private Integer importerExporterId;

    private Integer chamberId;

    private String chamberName;

    private String registrationNumber;

    private String positionId;

    private String positionDescription;

    private String linkTypeId;

    private String linkTypeDescription;

    private String linkDate;

}

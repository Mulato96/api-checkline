package com.sico.api.checkinline.domain.models.linkedverification;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkedVerification {

    private Long clientId;

    private String clientIdentificationType;

    private String clientIdentification;

    private String clientName;

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

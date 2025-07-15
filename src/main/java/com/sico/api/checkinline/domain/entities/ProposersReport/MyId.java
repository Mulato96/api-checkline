package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MyId implements Serializable {
    private String consecutiveReportNumber;
    private String description;
    private String experienceClass;
    private String family;
}

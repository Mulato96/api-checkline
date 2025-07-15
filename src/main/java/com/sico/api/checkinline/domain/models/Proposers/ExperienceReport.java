package com.sico.api.checkinline.domain.models.Proposers;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExperienceReport implements Serializable {


    private String consecutiveReportNumber;

    private String contractorName;

    private String clientName;

    private double executedContractValue;

    private String participatcionPercentage;

    private String segment;

    private String family;

    private String experienceClass;

    private String product;

    private String description;
}

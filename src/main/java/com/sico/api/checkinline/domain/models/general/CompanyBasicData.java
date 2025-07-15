package com.sico.api.checkinline.domain.models.general;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyBasicData {
    private String idNumber;
    private String register;
    private String registerStatus;
    private String category;
    private String commerceChamber;
    private String ciiu;
    private String economicActivity;
    private String organizationType;
    private String companyName;
    private LocalDate cancellationDate;
    private String idType;
    private LocalDate registerDate;
    private String address;
    private LocalDate renewalDate;
    private String municipality;
}

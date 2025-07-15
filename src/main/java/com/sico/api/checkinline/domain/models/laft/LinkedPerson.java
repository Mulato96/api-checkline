package com.sico.api.checkinline.domain.models.laft;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkedPerson {
    private String registrationNumber;
    private String linkedPersonName;
    private String identificationType;
    private String identificationNumber;
    private String position;
}

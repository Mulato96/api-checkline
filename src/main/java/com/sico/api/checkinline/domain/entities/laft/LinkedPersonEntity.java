package com.sico.api.checkinline.domain.entities.laft;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LinkedPersonEntity {
    @Id
    private String registrationNumber;
    private String linkedPersonName;
    private String identificationType;
    private String identificationNumber;
    private String position;
}

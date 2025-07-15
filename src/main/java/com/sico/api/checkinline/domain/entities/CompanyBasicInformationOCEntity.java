package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COIVE_INFORMACION_BASICA_OC")
public class CompanyBasicInformationOCEntity {

    @Id
    @Column(name = "NumId")
    private String identification;
    @Column(name = "NroMatricula")
    private String registeredId;
    @Column(name = "ID_CAMARA")
    private Long chamberId;
}
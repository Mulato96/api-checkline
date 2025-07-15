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
@Table(name = "COIVE_INFORMACION_BASICA")
public class CompanyBasicInformationEntity {

    @Id
    @Column(name = "id_cliente")
    private Long companyId;
    @Column(name = "id_matriculado")
    private Long registeredId;
}

package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyInformationEntity {
    @Id
    @Column(name = "IdEmpresa")
    private String idCompany;

    @Column(name = "EsBogota")
    private Boolean isBogota;
}

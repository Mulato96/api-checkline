package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class LegalRepresentativeEntity implements Serializable {

    @Column(name = "IdEmpresa")
    private String companyId;

    @Column(name = "TipoIdentificacion")
    private String documentType;

    @Id
    @Column(name = "Identificacion")
    private String identification;

    @Column(name = "Nombre")
    private String name;

    @Column(name = "Cargo")
    private String position;
}

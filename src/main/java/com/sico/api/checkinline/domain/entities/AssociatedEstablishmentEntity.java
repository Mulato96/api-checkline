package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class AssociatedEstablishmentEntity implements Serializable {

    @Id
    @Column(name = "RazonSocial")
    private String corporateName;

    @Column(name = "Camara")
    private String house;

    @Column(name = "Matricula")
    private String register;

    @Column(name = "EstadoMatricula")
    private String registerStatus;

    @Column(name = "Categoria")
    private String category;

    @Column(name = "Direccion")
    private String address;

    @Column(name = "FechaRenovacion")
    private String renewalDate;

    @Column(name = "UltimoAnioRenovado")
    private Integer lastYearRenewal;

    @Column(name = "IdEmpresa")
    private String companyId;
}

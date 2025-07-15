package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class CompanySearchEntity {

    @Id
    @Column(name = "IdEmpresa")
    private String companyId;

    @Column(name = "EsBogota")
    private boolean isBogota;

    @Column(name = "Identificacion")
    private String identification;

    @Column(name = "NombreRazonSocial")
    private String corporateName;

    @Column(name = "Sigla")
    private String initials;

    @Column(name = "EstadoMatricula")
    private String registrationState;

    @Column(name = "Matricula")
    private String registration;

    @Column(name = "CiudadDepartamento")
    private String cityDepartment;

    @Column(name = "Categoria")
    private String category;

    @Column(name = "Tamanio")
    private String size;

    @Column(name = "Sector")
    private String sector;

    @Column(name = "Direccion")
    private String address;

    @Column(name = "Camara")
    private String chamber;

    @Column(name = "Matriculado")
    private String registered;

}

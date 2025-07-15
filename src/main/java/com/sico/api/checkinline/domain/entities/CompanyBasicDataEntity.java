package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class CompanyBasicDataEntity {

    @Id
    @Column(name = "NumId")
    private String idNumber;
    @Column(name = "NroMatricula")
    private String register;
    @Column(name = "EstadoMatricula")
    private String registerStatus;
    @Column(name = "CategoriaEmpresa")
    private String category;
    @Column(name = "CiudadJudicial")
    private String commerceChamber;
    @Column(name = "CodActividadEconomica")
    private String ciiu;
    @Column(name = "ActividadEconomica")
    private String economicActivity;
    @Column(name = "OrganizacionJuridica")
    private String organizationType;
    @Column(name = "NombreCliente")
    private String companyName;
    @Column(name = "FecCancelacion")
    private LocalDate cancellationDate;
    @Column(name = "Documento")
    private String idType;
    @Column(name = "FecMatricula")
    private LocalDate registerDate;
    @Column(name = "DirComercial")
    private String address;
    @Column(name = "FecRenovacion")
    private LocalDate renewalDate;
    @Column(name = "CiudadComercial")
    private String municipality;

}

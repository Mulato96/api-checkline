package com.sico.api.checkinline.domain.entities.legalrepresentation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class IdentificationEntity {



    @Column(name="nombre_matriculado")
    private String businessName;

    @Column(name="desc_tipo_identificacion")
    private String identificationType;

    @Id
    @Column(name="nro_identificacion")
    private String identificationNumber;

    @Column(name="desc_camara")
    private String chamberOfCommerce;

    @Column(name="nro_matricula")
    private String registrationNumber;

    @Column(name="OrganizacionJuridica")
    private String legalOrganization;

    @Column(name="Domicilio")
    private String address;

    @Column(name="FecRenovacion")
    private String renewalDate;

    @Column(name="UltimoAnoRenova")
    private String lastRenewedYear;

    @Column(name="DirJudicial")
    private String judicialNotificationAddress;

    @Column(name="CiudadJudicial")
    private String judicialNotificationMunicipality;

    @Column(name="email_notif")
    private String judicialNotificationEmail;

    @Column(name="DirComercial")
    private String commercialAddress;

    @Column(name="CiudadComercial")
    private String commercialMunicipality;

    @Column(name="email")
    private String commercialEmail;

    @Column(name="Telefono")
    private String commercialPhone;

    @Column(name="ActividadEconomica")
    private String primaryEconomicActivity;

    //@Column(name="")
    //private String secondaryEconomicActivity;
}

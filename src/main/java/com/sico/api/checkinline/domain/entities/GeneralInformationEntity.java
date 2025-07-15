package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class GeneralInformationEntity implements Serializable {

  @Id
  @Column(name = "IdEmpresa")
  private String companyId;

  @Column(name = "RazonSocial")
  private String corporateName;

  @Column(name = "TipoIdentificacion")
  private String identificationType;

  @Column(name = "Identificacion")
  private String identification;

  @Column(name = "Matricula")
  private String register;

  @Column(name = "Sigla")
  private String acronym;

  @Column(name = "OrganizacionJuridica")
  private String legalOrganization;

  @Column(name = "Camara")
  private String house;

  @Column(name = "EstadoMatricula")
  private String registerStatus;

  @Column(name = "FechaMatricula")
  private String registerDate;

  @Column(name = "FechaRenovacion")
  private String renewalDate;

  @Column(name = "UltimoAnioRenovado")
  private Integer lastYearRenewal;

  @Column(name = "FechaCancelacion")
  private String cancellationDate;

  @Column(name = "Embargo")
  private String foreclosure;

  @Column(name = "Concordato")
  private String concordat;

  @Column(name = "DireccionComercial")
  private String businessAddress;

  @Column(name = "DepartamentoComercial")
  private String businessDepartment;

  @Column(name = "CiudadComercial")
  private String businessCity;

  @Column(name = "CodigoPostalComercial")
  private String businessZipCode;

  @Column(name = "TelefonoComercial")
  private String businessPhone;

  @Column(name = "CorreoComercial")
  private String businessMail;

  @Column(name = "AAComercial")
  private String businessAirmail;

  @Column(name = "DireccionWebComercial")
  private String businessWebAddress;

  @Column(name = "DireccionJudicial")
  private String legalAddress;

  @Column(name = "DepartamentoJudicial")
  private String legalDepartment;

  @Column(name = "CiudadJudicial")
  private String legalCity;

  @Column(name = "CodigoPostalJudicial")
  private String legalZipCode;

  @Column(name = "TelefonoJudicial")
  private String legalPhone;

  @Column(name = "CorreoJudicial")
  private String legalMail;

  @Column(name = "AAJudicial")
  private String legalAirmail;

  @Column(name = "DireccionWebJudicial")
  private String legalWebAddress;

  @Column(name = "Longitud")
  private String longitude;

  @Column(name = "Latitud")
  private String latitude;

  @Column(name = "CIIU1")
  private String ciiu1;

  @Column(name = "DescripcionCIIU1")
  private String descriptionCiiu1;

  @Column(name = "CIIU2")
  private String ciiu2;

  @Column(name = "DescripcionCIIU2")
  private String descriptionCiiu2;

  @Column(name = "CIIU3")
  private String ciiu3;

  @Column(name = "DescripcionCIIU3")
  private String descriptionCiiu3;

  @Column(name = "CIIU4")
  private String ciiu4;

  @Column(name = "DescripcionCIIU4")
  private String descriptionCiiu4;

  @Column(name = "ObjetoSocial")
  private String companyObject;

  @Column(name = "FalcultadesRepresentanteLegal")
  private String facultiesLegalRepresentative;

  @Column(name = "TamanioEmpresa")
  private String companySize;

  /*@Column(name = "TipoRegimen")
  private String regimeType;

  @Column(name = "Categoria")
  private String businessCategory;

  @Column(name = "IndicadorLiquidacion")
  private String settlementIndicator;

  @Column(name = "DescripcionActividadEconomica")
  private String descriptionEconomicActivity;

  @Column(name = "EstadoAfilicacion")
  private String statusAffiliation;

  @Column(name = "FechaDatos")
  private String dateDate;

  @Column(name = "MatriculaId")
  private String registerId;*/

}

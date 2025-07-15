package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class RenewalEntity implements Serializable {

  @Column(name = "IdEmpresa")
  private String companyId;

  @Id
  @Column(name = "FechaRenovacionAnioAnterior")
  private Integer previousRenewalYear;

  @Column(name = "FechaRenovacionAnterior")
  private String previousRenewalDate;


}

package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class EmployeeEntity implements Serializable {

  @Column(name = "IdEmpresa")
  private String companyId;

  @Id
  @Column(name = "Anio")
  private Integer year;

  @Column(name = "Empleados")
  private Integer quantity;
}

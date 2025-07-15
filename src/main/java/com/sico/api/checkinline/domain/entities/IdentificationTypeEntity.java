package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lu_tipo_identificacion")
public class IdentificationTypeEntity {

  @Id
  @Column(name = "id_tipo_identificacion")
  private String id;

  @Column(name = "desc_tipo_identificacion")
  private String description;

  @Column(name = "desc_corta_tipo_id")
  private String descriptionShort;

  @Column(name = "desc_label_identificacion_laft")
  private String labelLaft;

  @Column(name = "naturaleza_Juridica")
  private String legalNature;

  @Column(name = "habilitado_para_uso_laft")
  private Boolean useLaft;
}


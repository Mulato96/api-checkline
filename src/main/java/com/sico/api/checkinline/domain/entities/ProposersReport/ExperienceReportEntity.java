package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@IdClass(MyId.class)
public class ExperienceReportEntity {

    @Id
    @Column(name= "NUMERO_CONSECUTIVO_REPORTE")
    private String consecutiveReportNumber;

    @Column(name= "NOMBRE_CONTRATISTA")
    private String contractorName;

    @Column(name= "NOMBRE_CONTRATANTE")
    private String clientName;

    @Column(name= "VALOR_CONTRATO_EJECUTADO_SMMLV")
    private double executedContractValue;

    @Column(name= "PORCENTAJE_PARTICIPACION_VALOR_EJECUTADO_CC")
    private String participatcionPercentage;

    @Column(name= "SEGMENTO")
    private String segment;

    @Id
    @Column(name= "FAMILIA")
    private String family;

    @Column(name= "CLASIFICACION")
    private String experienceClass;

    @Column(name= "PRODUCTO")
    private String product;

    @Id
    @Column(name= "DESCRIPCION_Y_CLASIFICACION")
    private String description;
}

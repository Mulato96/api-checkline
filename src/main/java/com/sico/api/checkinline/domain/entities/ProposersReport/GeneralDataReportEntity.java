package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class GeneralDataReportEntity implements Serializable {

    @Id
    @Column(name= "NIT")
    private String nit;

    @Column(name="NUM_PROPONENTE")
    private String proposersNumber;

    @Column(name = "FECHA_INSCRIPCION")
    private Date inscriptionDate;

    @Column(name = "FECHA_ULTIMARENOVACION")
    private Date lastRenotationDate;

    @Column(name = "TAMANIO")
    private String size;

}

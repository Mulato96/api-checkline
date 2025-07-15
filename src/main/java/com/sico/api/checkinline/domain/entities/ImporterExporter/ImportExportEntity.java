package com.sico.api.checkinline.domain.entities.ImporterExporter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ImportExportEntity
{
    @Column(name = "Nombre")
    private String name;

    @Column(name = "Origen")
    private String origin;

    @Column(name = "Destino")
    private String destination;

    @Column(name = "PosicionArancel")
    private String tariff;

    @Column(name = "Peso")
    private String weight;

    @Column(name = "NumArticulos")
    private String numArticles;

    @Id
    @Column(name = "Valor")
    private String value;

    @Column(name = "FECHA")
    private Date date;
}

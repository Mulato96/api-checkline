package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class ClasificationReportEntity {

    @Id
    @Column(name = "DESCRIPCION_CLASIFICACION")
    private String description;

    @Column(name = "SEGMENTO")
    private String segment;

    @Column(name = "FAMILIA")
    private String family;

    @Column(name = "CLASIFICACION")
    private String clasificationClass;

    @Column(name = "PRODUCTO")
    private String product;
}

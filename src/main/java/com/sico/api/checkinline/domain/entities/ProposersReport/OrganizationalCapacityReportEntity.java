package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrganizationalCapacityReportEntity {
    @Id
    @Column(name= "RENTABILIDAD_PATRIMONIO")
    private double rentabilidadPatrimonio;
    @Column(name= "RENTABILIDAD_ACTIVO")
    private double retabilidadActivo;
}

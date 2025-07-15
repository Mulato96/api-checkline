package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FinancialCapacityReportEntity {

    @Id
    @Column(name= "INDICE_LIQUIDEZ")
    private double liquidityRatio;
    @Column(name= "INDICE_ENDEUDAMIENTO")
    private double debtRatio;
    @Column(name= "RAZON_COBERTURA_INTERES")
    private double interestCoverageRatio;

}

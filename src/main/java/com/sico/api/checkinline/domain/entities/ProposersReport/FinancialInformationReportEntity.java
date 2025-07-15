package com.sico.api.checkinline.domain.entities.ProposersReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class FinancialInformationReportEntity {


    //Informacion Financiera
    @Column(name= "FECHA_CORTE_INFO_FINANCIERA")
    private Date cutoffDate;

    @Id
    @Column(name= "ACTIVO_CORRIENTE")
    private double currentAssets;

    @Column(name= "ACTIVO_TOTAL")
    private double totalAssets;

    @Column(name= "PASIVO_CORRIENTE")
    private double currentLiabilities;

    @Column(name= "PASIVO_TOTAL")
    private double totalLiabilities;

    @Column(name= "PATRIMONIO")
    private double equity;

    @Column(name= "UTILIDAD_PERDIDA_OPERACIONAL")
    private double operatingProfitLoss;

    @Column (name = "GASTOS_DE_INTERESES")
    private double interestExpenses;
}

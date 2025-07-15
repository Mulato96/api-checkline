package com.sico.api.checkinline.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CCUNION_RM_FIN")
public class FinancialReportEntity {

    @EmbeddedId
    private FinancialReportId id;

    @Column(name = "CNT_PERSONAL")
    private BigDecimal cntPersonal;

    @Column(name = "VRCAPTAUTORIZADO")
    private BigDecimal authorizedCapturedValue;

    @Column(name = "VRCAPTSUSCRITO")
    private BigDecimal subscribedCapital;

    @Column(name = "VRCAPPAGADO")
    private BigDecimal paidCapital;

    @Column(name = "VRCAPSOCIAL")
    private BigDecimal socialCapital;

    @Column(name = "VRCAPSUCEXT")
    private BigDecimal extSuCapital;

    @Column(name = "ACTIVOCORRIENTE")
    private BigDecimal currentAsset;

    @Column(name = "ACTIVOFIJO")
    private BigDecimal fixedAsset;

    @Column(name = "OTROSACTI")
    private BigDecimal otherAssets;

    @Column(name = "VALORACIONACTI")
    private BigDecimal assetValuation;

    @Column(name = "VRTOTACTIBRUTOS")
    private BigDecimal totalGrossAssets;

    @Column(name = "VRACTISAJUSTESINFL")
    private BigDecimal inflationAdjustmentAssets;

    @Column(name = "VRPASICORRIENTE")
    private BigDecimal passiveCurrents;

    @Column(name = "VRPASILARGOPLAZO")
    private BigDecimal longTermPassive;

    @Column(name = "VRTOTPASI")
    private BigDecimal totalPassive;

    @Column(name = "VRPATRIM")
    private BigDecimal heritageValue;

    @Column(name = "VRTOTPASIPAT")
    private BigDecimal totalPassiveHeritage;

    @Column(name = "VRVENTASNETAS")
    private BigDecimal netSales;

    @Column(name = "VRCOSTOVENTAS")
    private BigDecimal salesCost;

    @Column(name = "VRGASTOSADMON")
    private BigDecimal administrativeExpenses;

    @Column(name = "VRUTILI")
    private BigDecimal utilityValue;

    @Column(name = "VRUTILIOPER")
    private BigDecimal operatingUtility;

    @Column(name = "VRINGNOOPER")
    private BigDecimal nonOperatingIncome;

    @Column(name = "VRESTABLE")
    private BigDecimal stableValue;

    @Column(name = "FEC_DATOS")
    private LocalDateTime dateData;

    @Column(name = "VRACTIVO_NO_CORRIENTE")
    private BigDecimal noCurrentAsset;

    @Column(name = "VRPASIVO_NO_CORRIENTE")
    private BigDecimal nonCurrentPassive;

    @Column(name = "VRBALANCE_SOCIAL")
    private BigDecimal socialBalance;

    @Column(name = "VRVALOR_OTROS_INGRESOS")
    private BigDecimal othersIncome;

    @Column(name = "VRVALOR_OTROS_GASTOS")
    private BigDecimal otherExpenses;

    @Column(name = "VRVALOR_GASTOS_IMPUESTOS")
    private BigDecimal taxesExpenses;

    @Column(name = "VRGASTOSOPERACIONALES2017")
    private BigDecimal operationalExpenses;

}

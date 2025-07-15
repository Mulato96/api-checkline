package com.sico.api.checkinline.domain.models.financialReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialReportLocal {

    private Long registeredId;

    private int yearReported;

    private int validData;

    private LocalDateTime dateData;

    private String currencyId;

    private String invoiceId;

    private BigDecimal currentAssets;

    private BigDecimal fixedAssets;

    private BigDecimal assetsValuation;

    private BigDecimal otherAssets;

    private BigDecimal totalGrossAssets;

    private BigDecimal assetsAdjustment;

    private BigDecimal passiveCurrents;

    private BigDecimal longTermObligation;

    private BigDecimal totalPassive;

    private BigDecimal heritageLiquidated;

    private BigDecimal totalPassiveHeritage;

    private BigDecimal netSales;

    private BigDecimal salesCost;

    private BigDecimal lostUtilityOperation;

    private BigDecimal lostUtilityNet;

    private BigDecimal administrativeExpenses;

    private BigDecimal busyStaff;

    private String activeRange;

    private String rangeNumberEmployees;

    private BigDecimal establecimientoValue;

    private BigDecimal operationalExpenses;

    private BigDecimal noCurrentAsset;

    private BigDecimal socialBalance;

    private BigDecimal nonCurrentPassive;

    private BigDecimal taxesExpenses;

    private BigDecimal otherExpenses;

    private BigDecimal ordinaryActiveIncome;

    private BigDecimal othersIncome;

}

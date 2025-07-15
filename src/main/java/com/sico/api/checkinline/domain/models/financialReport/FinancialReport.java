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
public class FinancialReport {

    private String registeredNum;

    private int yearData;

    private LocalDateTime dateData;

    private BigDecimal currentAsset;

    private BigDecimal fixedAsset;

    private BigDecimal assetValuation;

    private BigDecimal otherAssets;

    private BigDecimal totalGrossAssets;

    private BigDecimal passiveCurrents;

    private BigDecimal totalPassive;

    private BigDecimal heritageValue;

    private BigDecimal totalPassiveHeritage;

    private BigDecimal netSales;

    private BigDecimal salesCost;

    private BigDecimal administrativeExpenses;

    private BigDecimal establishmentValue;

    private BigDecimal operationalExpenses;

    private BigDecimal noCurrentAsset;

    private BigDecimal socialBalance;

    private BigDecimal nonCurrentPassive;

    private BigDecimal taxesExpenses;

    private BigDecimal otherExpenses;

    private BigDecimal othersIncome;

    //otros valores tabla ft_his_estados_financieros
    private int validData;

    private String currencyId;

    private String invoiceId;

    private BigDecimal assetsAdjustment;

    private BigDecimal longTermObligation;

    private BigDecimal lostUtilityOperation;

    private BigDecimal lostUtilityNet;

    private BigDecimal busyStaff;

    private String activeRange;

    private String rangeNumberEmployees;

    private BigDecimal ordinaryActiveIncome;

    //otros valores tabla CCUNION_RM_FIN
    private BigDecimal nonOperatingIncome;

    private BigDecimal operatingUtility;

    private BigDecimal utilityValue;

    private BigDecimal longTermPassive;

    private BigDecimal inflationAdjustmentAssets;

    private BigDecimal extSuCapital;

    private BigDecimal socialCapital;

    private BigDecimal paidCapital;

    private BigDecimal subscribedCapital;

    private BigDecimal authorizedCapturedValue;

    private BigDecimal cntPersonal;

}

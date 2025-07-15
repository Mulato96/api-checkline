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
@Table(name = "ft_his_estados_financieros")
public class FinancialReportLocalEntity {

    @EmbeddedId
    private FinancialReportLocalId id;

    @Column(name = "id_dato_valido")
    private int validData;

    @Column(name = "id_fecha_datos")
    private LocalDateTime dateData;

    @Column(name = "id_moneda")
    private String currencyId;

    @Column(name = "id_factura")
    private String invoiceId;

    @Column(name = "vlr_acti_corrientes")
    private BigDecimal currentAssets;

    @Column(name = "vlr_acti_fijos")
    private BigDecimal fixedAssets;

    @Column(name = "vlr_valoracion_activos")
    private BigDecimal assetsValuation;

    @Column(name = "vlr_otros_acti")
    private BigDecimal otherAssets;

    @Column(name = "vlr_tot_acti_brutos")
    private BigDecimal totalGrossAssets;

    @Column(name = "vlr_acti_sin_ajuste")
    private BigDecimal assetsAdjustment;

    @Column(name = "vlr_pasi_corrientes")
    private BigDecimal passiveCurrents;

    @Column(name = "vlr_obliga_largopl")
    private BigDecimal longTermObligation;

    @Column(name = "vlr_tot_pasi")
    private BigDecimal totalPassive;

    @Column(name = "vlr_patrim_liq")
    private BigDecimal heritageLiquidated;

    @Column(name = "vlr_tot_pasi_patrim")
    private BigDecimal totalPassiveHeritage;

    @Column(name = "vlr_ventas_netas")
    private BigDecimal netSales;

    @Column(name = "vlr_costo_ventas")
    private BigDecimal salesCost;

    @Column(name = "vlr_utilidad_perdida_ope")
    private BigDecimal lostUtilityOperation;

    @Column(name = "vlr_utilidad_perdida_neta")
    private BigDecimal lostUtilityNet;

    @Column(name = "vlr_gastos_admon")
    private BigDecimal administrativeExpenses;

    @Column(name = "nro_personal_ocupado")
    private BigDecimal busyStaff;

    @Column(name = "id_rango_activos")
    private String activeRange;

    @Column(name = "id_rango_nro_empleados")
    private String rangeNumberEmployees;

    @Column(name = "vlr_establecimiento")
    private BigDecimal establishmentValue;

    @Column(name = "VLR_GASTOS_OPERACIONALES")
    private BigDecimal operationalExpenses;

    @Column(name = "VLR_ACT_NO_CORRIENTE")
    private BigDecimal noCurrentAsset;

    @Column(name = "VLR_BALANCE_SOCIAL")
    private BigDecimal socialBalance;

    @Column(name = "VLR_PAS_NO_CORRIENTE")
    private BigDecimal nonCurrentPassive;

    @Column(name = "VLR_GASTOS_IMPUESTOS")
    private BigDecimal taxesExpenses;

    @Column(name = "VLR_OTROS_GASTOS")
    private BigDecimal otherExpenses;

    @Column(name = "VLR_ING_ACTIV_ORDINARIA")
    private BigDecimal ordinaryActiveIncome;

    @Column(name = "VLR_OTROS_INGRESOS")
    private BigDecimal othersIncome;

}

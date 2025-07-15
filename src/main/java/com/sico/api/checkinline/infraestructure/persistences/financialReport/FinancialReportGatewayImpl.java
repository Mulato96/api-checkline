package com.sico.api.checkinline.infraestructure.persistences.financialReport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sico.api.checkinline.domain.entities.FinancialReportEntity;
import com.sico.api.checkinline.domain.entities.FinancialReportLocalEntity;
import com.sico.api.checkinline.domain.models.financialReport.FinancialReport;
import com.sico.api.checkinline.infraestructure.gateways.financialReport.FinancialReportGateway;
import com.sico.api.checkinline.infraestructure.utils.UtilDate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FinancialReportGatewayImpl implements FinancialReportGateway {

    private final FinancialReportLocalRepository financialReportLocalRepository;
    private final FinancialReportRepository financialReportRepository;

    LocalDateTime currentDate = UtilDate.getCurrentDate();
    LocalDateTime initialDate = currentDate.minusYears(5);
    int startDate = initialDate.getYear();
    int endDate = currentDate.getYear();
    int validData = 2;


    @Override
    public List<FinancialReport> getFinancialReportList(boolean isBogota, String registrationNumber, Integer chamberId, String registered) {
        List<FinancialReport> financialList = new ArrayList<>();
        if (isBogota) {

            List<FinancialReportLocalEntity> resultList = financialReportLocalRepository
                    .getFinancialReportLocalList(Long.parseLong(registered), validData, startDate, endDate);

            resultList.forEach(data -> {

                FinancialReport financialReport = FinancialReport.builder()
                        .administrativeExpenses(data.getAdministrativeExpenses())
                        .assetValuation(data.getAssetsValuation())
                        .currentAsset(data.getCurrentAssets())
                        .dateData(data.getDateData())
                        .establishmentValue(data.getEstablishmentValue())
                        .fixedAsset(data.getFixedAssets())
                        .heritageValue(data.getHeritageLiquidated())
                        .netSales(data.getNetSales())
                        .noCurrentAsset(data.getNoCurrentAsset())
                        .nonCurrentPassive(data.getNonCurrentPassive())
                        .operationalExpenses(data.getOperationalExpenses())
                        .otherAssets(data.getOtherAssets())
                        .otherExpenses(data.getOtherExpenses())
                        .othersIncome(data.getOthersIncome())
                        .passiveCurrents(data.getPassiveCurrents())
                        .registeredNum(data.getId().getRegisteredId().toString())
                        .salesCost(data.getSalesCost())
                        .socialBalance(data.getSocialBalance())
                        .taxesExpenses(data.getTaxesExpenses())
                        .totalGrossAssets(data.getTotalGrossAssets())
                        .totalPassive(data.getTotalPassive())
                        .totalPassiveHeritage(data.getTotalPassiveHeritage())
                        .yearData(data.getId().getYearReported())
                        .activeRange(data.getActiveRange())
                        .assetsAdjustment(data.getAssetsAdjustment())
                        .busyStaff(data.getBusyStaff())
                        .currencyId(data.getCurrencyId())
                        .invoiceId(data.getInvoiceId())
                        .longTermObligation(data.getLongTermObligation())
                        .lostUtilityNet(data.getLostUtilityNet())
                        .lostUtilityOperation(data.getLostUtilityOperation())
                        .ordinaryActiveIncome(data.getOrdinaryActiveIncome())
                        .rangeNumberEmployees(data.getRangeNumberEmployees())
                        .validData(data.getValidData())
                        .build();

                financialList.add(financialReport);
            });
        } else {

            List<FinancialReportEntity> resultList = financialReportRepository
                    .getFinancialReportList(registrationNumber, chamberId, startDate, endDate);

            resultList.forEach(data -> {

                FinancialReport financialReport = FinancialReport.builder()
                        .administrativeExpenses(data.getAdministrativeExpenses())
                        .assetValuation(data.getAssetValuation())
                        .currentAsset(data.getCurrentAsset())
                        .dateData(data.getDateData())
                        .establishmentValue(data.getStableValue())
                        .fixedAsset(data.getFixedAsset())
                        .heritageValue(data.getHeritageValue())
                        .netSales(data.getNetSales())
                        .noCurrentAsset(data.getNoCurrentAsset())
                        .nonCurrentPassive(data.getNonCurrentPassive())
                        .operationalExpenses(data.getOperationalExpenses())
                        .otherAssets(data.getOtherAssets())
                        .otherExpenses(data.getOtherExpenses())
                        .othersIncome(data.getOthersIncome())
                        .passiveCurrents(data.getPassiveCurrents())
                        .registeredNum(data.getId().getRegisteredNum().toString())
                        .salesCost(data.getSalesCost())
                        .socialBalance(data.getSocialBalance())
                        .taxesExpenses(data.getTaxesExpenses())
                        .totalGrossAssets(data.getTotalGrossAssets())
                        .totalPassive(data.getTotalPassive())
                        .totalPassiveHeritage(data.getTotalPassiveHeritage())
                        .yearData(data.getId().getYearData())
                        .authorizedCapturedValue(data.getAuthorizedCapturedValue())
                        .cntPersonal(data.getCntPersonal())
                        .extSuCapital(data.getExtSuCapital())
                        .inflationAdjustmentAssets(data.getInflationAdjustmentAssets())
                        .longTermPassive(data.getLongTermPassive())
                        .nonOperatingIncome(data.getNonOperatingIncome())
                        .operatingUtility(data.getOperatingUtility())
                        .paidCapital(data.getPaidCapital())
                        .socialCapital(data.getSocialCapital())
                        .subscribedCapital(data.getSubscribedCapital())
                        .utilityValue(data.getUtilityValue())
                        .build();

                financialList.add(financialReport);
            });
        }

        return financialList;
    }

}

package com.sico.api.checkinline.domain.models.Proposers;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class FinancialInformationReport implements Serializable {

    private Date cutoffDate;

    private double currentAssets;

    private double totalAssets;

    private double currentLiabilities;

    private double totalLiabilities;

    private double equity;

    private double operatingProfitLoss;

    private double interestExpenses;
}

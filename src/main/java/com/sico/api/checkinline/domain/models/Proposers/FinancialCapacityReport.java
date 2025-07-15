package com.sico.api.checkinline.domain.models.Proposers;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class FinancialCapacityReport implements Serializable {

    private double liquidityRatio;

    private double debtRatio;

    private double interestCoverageRatio;
}

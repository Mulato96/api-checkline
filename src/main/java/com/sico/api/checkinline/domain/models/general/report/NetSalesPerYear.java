package com.sico.api.checkinline.domain.models.general.report;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NetSalesPerYear implements Serializable {

    private Integer year;

    private Integer netSales;
}

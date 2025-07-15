package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class NetSalesPerYearEntity implements Serializable {

    @Column(name = "IdEmpresa")
    private String companyId;

    @Id
    @Column(name = "Anio")
    private Integer year;

    @Column(name = "VentasNetas")
    private Integer netSales;

}

package com.sico.api.checkinline.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FinancialReportId implements Serializable {
    
    @Column(name = "ID_CAMARA")
    private Long chamberId;

    @Column(name = "NUM_MATRICULA")
    private String registeredNum;

    @Column(name = "ANO_DATOS")
    private int yearData;



    public Long getChamberId() {
        return chamberId;
    }

    public String getRegisteredNum() {
        return registeredNum;
    }

    public int getYearData() {
        return yearData;
    }

    public void setChamberId(Long chamberId) {
        this.chamberId = chamberId;
    }

    public void setRegisteredNum(String registeredNum) {
        this.registeredNum = registeredNum;
    }

    public void setYearData(int yearData) {
        this.yearData = yearData;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chamberId == null) ? 0 : chamberId.hashCode());
        result = prime * result + ((registeredNum == null) ? 0 : registeredNum.hashCode());
        result = prime * result + yearData;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FinancialReportId other = (FinancialReportId) obj;
        if (chamberId == null) {
            if (other.chamberId != null)
                return false;
        } else if (!chamberId.equals(other.chamberId))
            return false;
        if (registeredNum == null) {
            if (other.registeredNum != null)
                return false;
        } else if (!registeredNum.equals(other.registeredNum))
            return false;
        if (yearData != other.yearData)
            return false;
        return true;
    }

    

}

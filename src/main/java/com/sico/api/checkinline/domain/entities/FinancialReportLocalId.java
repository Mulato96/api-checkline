package com.sico.api.checkinline.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FinancialReportLocalId implements Serializable {

    @Column(name = "id_matriculado")
    private Long registeredId;

    @Column(name = "id_ano_reportado")
    private int yearReported;

    

    public Long getRegisteredId() {
        return registeredId;
    }

    public int getYearReported() {
        return yearReported;
    }

    public void setRegisteredId(Long registeredId) {
        this.registeredId = registeredId;
    }

    public void setYearReported(int yearReported) {
        this.yearReported = yearReported;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((registeredId == null) ? 0 : registeredId.hashCode());
        result = prime * result + yearReported;
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
        FinancialReportLocalId other = (FinancialReportLocalId) obj;
        if (registeredId == null) {
            if (other.registeredId != null)
                return false;
        } else if (!registeredId.equals(other.registeredId))
            return false;
        if (yearReported != other.yearReported)
            return false;
        return true;
    }

    
    
}

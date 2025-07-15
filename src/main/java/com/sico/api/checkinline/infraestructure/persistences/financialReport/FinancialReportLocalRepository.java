package com.sico.api.checkinline.infraestructure.persistences.financialReport;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sico.api.checkinline.domain.entities.FinancialReportLocalEntity;

public interface FinancialReportLocalRepository extends JpaRepository<FinancialReportLocalEntity, Long> {

    @Query("SELECT i FROM FinancialReportLocalEntity i WHERE i.id.registeredId =:registered " 
        + "AND i.validData =:validData AND i.id.yearReported BETWEEN :startDate AND :endDate "
        + "ORDER BY i.id.yearReported")
    List<FinancialReportLocalEntity> getFinancialReportLocalList(
        @Param("registered") Long registered, 
        @Param("validData") int validData,
        @Param("startDate") int startDate,
        @Param("endDate") int endDate);
    
}

package com.sico.api.checkinline.infraestructure.persistences.financialReport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sico.api.checkinline.domain.entities.FinancialReportEntity;

public interface FinancialReportRepository extends JpaRepository<FinancialReportEntity, String> {

    @Query("SELECT i FROM FinancialReportEntity i WHERE i.id.registeredNum =:registrationNumber "
           + "AND i.id.chamberId =:chamberId AND i.id.yearData BETWEEN :startDate AND :endDate ORDER BY i.id.yearData")
    List<FinancialReportEntity> getFinancialReportList(@Param("registrationNumber") String registrationNumber,
            @Param("chamberId") int chamberId,
            @Param("startDate") int startDate,
            @Param("endDate") int endDate);

}

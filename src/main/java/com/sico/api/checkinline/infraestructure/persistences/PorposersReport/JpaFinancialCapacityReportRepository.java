package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.entities.ProposersReport.FinancialCapacityReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaFinancialCapacityReportRepository extends JpaRepository<FinancialCapacityReportEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT top 1
            CC.NUM_ID AS NIT,
            Y.NUM_PROPONENTE,
            CF.VR_LIQUIDEZ AS INDICE_LIQUIDEZ,
            CF.VR_ENDEUDA AS INDICE_ENDEUDAMIENTO,
            CF.VR_COBERTURA_INTERESES AS RAZON_COBERTURA_INTERES
        FROM dbo.PR_PROPONENTES Y WITH (NOLOCK)
        INNER JOIN dbo.PR_CC_CLIENTES CC WITH (NOLOCK) ON Y.NUM_CLIENTE = CC.NUM_CLIENTE
        LEFT JOIN dbo.PR_CAPACIDAD_FINANCIERA CF WITH (NOLOCK)
            ON Y.NUM_PROPONENTE = CF.NUM_PROPONENTE
            AND CF.CTR_REGISTRO = 1
            WHERE CC.NUM_CLIENTE = :id
        """, nativeQuery = true)
    FinancialCapacityReportEntity consultFinancialCapacity(@Param("id") String id);
}

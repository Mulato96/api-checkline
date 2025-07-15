package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.entities.ProposersReport.FinancialInformationReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaFinancialInformationReportRepository extends JpaRepository<FinancialInformationReportEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT top 1
            CC.ID_MATRICULA,
            CC.NOMBRE,
            CC.ID_CLASE,
            CC.NUM_ID,
            Y.NUM_PROPONENTE,
            Y.FEC_ULT_INSC,
            Y.NUM_CLIENTE,
            I_F.FEC_DATOS AS FECHA_CORTE_INFO_FINANCIERA,
            ISNULL(I_F.VR_ACT_CORRIENTE, '0') AS ACTIVO_CORRIENTE,
            ISNULL(I_F.VR_ACT_TOTAL, '0') AS ACTIVO_TOTAL,
            ISNULL(I_F.VR_PAS_CORRIENTE, '0') AS PASIVO_CORRIENTE,
            ISNULL(I_F.VR_PAS_TOTAL, '0') AS PASIVO_TOTAL,
            ISNULL(I_F.VR_PATR_NETO, '0') AS PATRIMONIO,
            ISNULL(I_F.VR_UTIL_OPERACIONAL, '0') AS UTILIDAD_PERDIDA_OPERACIONAL,
         ISNULL(I_F.VR_GASTO_INTERESES, '0') AS GASTOS_DE_INTERESES
        FROM dbo.PR_PROPONENTES Y WITH (NOLOCK)
        INNER JOIN PR_CC_CLIENTES CC WITH (NOLOCK) ON Y.NUM_CLIENTE = CC.NUM_CLIENTE
        LEFT JOIN (
            SELECT  I.NUM_PROPONENTE,
                   I.FEC_DATOS,
                   I.VR_ACT_CORRIENTE,
                   I.VR_ACT_TOTAL,
                   I.VR_PAS_CORRIENTE,
                   I.VR_PAS_TOTAL,
                   I.VR_PATR_NETO,
                   I.VR_UTIL_OPERACIONAL,
                CF.VR_GASTO_INTERESES
            FROM PR_INF_FINANCIERA I WITH (NOLOCK)
         inner join PR_CAPACIDAD_FINANCIERA CF on I.NUM_PROPONENTE = CF.NUM_PROPONENTE
            WHERE I.CTR_REGISTRO = 1 AND CF.CTR_REGISTRO=1
        ) I_F ON Y.NUM_PROPONENTE = I_F.NUM_PROPONENTE
        WHERE CC.NUM_CLIENTE = :id 
        """, nativeQuery = true)
    FinancialInformationReportEntity consultFinancialInformation(@Param("id") String id);
}

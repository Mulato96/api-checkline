package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.entities.ProposersReport.ClasificationReportEntity;
import com.sico.api.checkinline.domain.entities.ProposersReport.GeneralDataReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface JpaClasificationReportRepository extends JpaRepository<ClasificationReportEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT DISTINCT
             CC.NUM_ID AS NIT,
             Y.NUM_PROPONENTE,
             ISNULL(SUBSTRING(AE.ID_CLASIFICACION, 1, 2), N'N/A') AS SEGMENTO,
             ISNULL(SUBSTRING(AE.ID_CLASIFICACION, 3, 2), N'N/A') AS FAMILIA,
             ISNULL(SUBSTRING(AE.ID_CLASIFICACION, 5, 2), N'N/A') AS CLASIFICACION,
             '00' AS PRODUCTO,
             UPPER(AG.NOM_CLASE) AS DESCRIPCION_CLASIFICACION
         FROM dbo.PR_PROPONENTES Y WITH (NOLOCK)
         INNER JOIN PR_CC_CLIENTES CC WITH (NOLOCK)
             ON Y.NUM_CLIENTE = CC.NUM_CLIENTE COLLATE DATABASE_DEFAULT
         LEFT JOIN dbo.PR_CLASIFICACION AF WITH (NOLOCK)
             ON AF.NUM_PROPONENTE COLLATE DATABASE_DEFAULT = Y.NUM_PROPONENTE
         LEFT JOIN dbo.PR_CLASIFICACION AE WITH (NOLOCK)
             ON AE.NUM_PROPONENTE = AF.NUM_PROPONENTE AND AE.ITEM = AF.ITEM
         LEFT JOIN dbo.PR_TA_BIENES_SERVICIOS AG WITH (NOLOCK)
             ON AG.ID_CLASIFICACION = AF.ID_CLASIFICACION
         WHERE CC.NUM_CLIENTE = :id
        """, nativeQuery = true)
    List<ClasificationReportEntity> consultClasification(@Param("id") String id);
}

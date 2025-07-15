package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.entities.ProposersReport.ExperienceReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface JpaExperienceReportRepository extends JpaRepository<ExperienceReportEntity,Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT DISTINCT
             CC.NUM_ID AS NIT,
             Y.NUM_PROPONENTE,
             AD.NOM_CONTRATISTA AS NOMBRE_CONTRATISTA,
             AD.NOM_CONTRATANTE AS NOMBRE_CONTRATANTE,
             AD.VR_CONTRATO AS VALOR_CONTRATO_EJECUTADO_SMMLV,
             ISNULL(AE.ID_CLASIFICACION, N'N/A') AS EXPERIENCIA_CLASIFICACION,
             ISNULL(SUBSTRING(AE.ID_CLASIFICACION, 1, 2), N'N/A') AS SEGMENTO,
             ISNULL(SUBSTRING(AE.ID_CLASIFICACION, 3, 2), N'N/A') AS FAMILIA,
             ISNULL(SUBSTRING(AE.ID_CLASIFICACION, 5, 2), N'N/A') AS CLASIFICACION,
             '00' AS PRODUCTO,
             UPPER(AG.NOM_CLASE) AS DESCRIPCION_Y_CLASIFICACION,
             ISNULL(CONVERT(nvarchar, AD.PCT_EJECUCION), N'') AS PORCENTAJE_PARTICIPACION_VALOR_EJECUTADO_CC,
             RIGHT(REPLICATE(0, 8) + LTRIM(RTRIM(AD.ID_CONTRATO)), 2) AS NUMERO_CONSECUTIVO_REPORTE
         FROM dbo.PR_PROPONENTES Y WITH (NOLOCK)
         INNER JOIN PR_CC_CLIENTES CC WITH (NOLOCK)
             ON Y.NUM_CLIENTE = CC.NUM_CLIENTE COLLATE DATABASE_DEFAULT
         INNER JOIN dbo.PR_EXPERIENCIA AD WITH (NOLOCK)
             ON AD.NUM_PROPONENTE = Y.NUM_PROPONENTE COLLATE DATABASE_DEFAULT
         INNER JOIN dbo.PR_EXPERIENCIA_CLASIFICACION AE WITH (NOLOCK)
             ON AE.NUM_PROPONENTE = AD.NUM_PROPONENTE AND AE.ITEM = AD.ITEM
         INNER JOIN dbo.PR_TA_BIENES_SERVICIOS AG WITH (NOLOCK)
             ON AG.ID_CLASIFICACION = AE.ID_CLASIFICACION
         WHERE CC.NUM_CLIENTE = :id
        """, nativeQuery = true)
    List<ExperienceReportEntity> consultExperience(@Param("id") String id);
}

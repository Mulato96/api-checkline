package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.entities.ProposersReport.GeneralDataReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaGeneralDataReportRepository extends JpaRepository<GeneralDataReportEntity,Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT TOP 1
             CC.ID_MATRICULA,
             CC.ID_CLASE,
             CC.NUM_ID AS NIT,
             Y.NUM_PROPONENTE,
             Y.FEC_ULT_INSC AS FECHA_INSCRIPCION,
             Y.NUM_CLIENTE,
             ISNULL(MAX(lib.FEC_INSCRIPCION), '') AS FECHA_ULTIMARENOVACION,
            CASE TE.ID_TAMANO
                 WHEN 1 THEN 'Microempresas'
                 WHEN 2 THEN 'Pequeña'
                 WHEN 3 THEN 'Mediana'
                 WHEN 4 THEN 'Grande'
             END AS TAMANIO
         FROM dbo.PR_PROPONENTES Y WITH (NOLOCK)
         INNER JOIN PR_CC_CLIENTES CC WITH (NOLOCK) ON Y.NUM_CLIENTE = CC.NUM_CLIENTE
         LEFT JOIN PR_LIBROS lib WITH (NOLOCK) ON Y.NUM_PROPONENTE = lib.NUM_PROPONENTE AND lib.ID_ACTO_PROPO = '3902'
         LEFT JOIN PR_TAMANO_EMPRESA TE WITH (NOLOCK) ON Y.NUM_PROPONENTE = TE.NUM_PROPONENTE COLLATE Modern_Spanish_CI_AS AND TE.CTR_REGISTRO = 1
         WHERE CC.NUM_CLIENTE = :id
         GROUP BY
             CC.ID_MATRICULA,
             CC.ID_CLASE,
             CC.NUM_ID,
             Y.NUM_PROPONENTE,
             Y.FEC_ULT_INSC,
             Y.NUM_CLIENTE,
            TE.ID_TAMANO
        """, nativeQuery = true)
    GeneralDataReportEntity consultGeneralData(@Param("id") String id);
}

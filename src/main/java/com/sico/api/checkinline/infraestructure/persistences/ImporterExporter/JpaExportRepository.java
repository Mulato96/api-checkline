package com.sico.api.checkinline.infraestructure.persistences.ImporterExporter;

import com.sico.api.checkinline.domain.entities.ImporterExporter.ImportExportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface JpaExportRepository extends JpaRepository<ImportExportEntity, Long> {
    @Transactional
    @Query(value = """
            SELECT DISTINCT
            ED.RAZN_EXP AS Nombre,
            ISNULL(H.desc_departamento_cliente, 'Sin informacion') AS Origen,
            K.desc_pais_cliente AS Destino,
            ED.POS_ARA3 + ': ' + ISNULL(SA.DESC_DETALLADA, 'No se encontró descripción') AS PosicionArancel,
            ED.KILO_NE3 AS Peso,
            ED.ARTICUL3 AS NumArticulos,
            ED.FOB_DOL3 AS Valor,
            CONVERT(Datetime, (SUBSTRING(ED.FECH_DE3, 1, 4) + '-' + SUBSTRING(ED.FECH_DE3, 5, 2) + '-' + CASE SUBSTRING(ED.FECH_DE3, 7, 2)  WHEN '00' THEN '01'  ELSE SUBSTRING(ED.FECH_DE3, 7, 2)  END)) AS FECHA
            FROM LU_CLIENTE CL
            INNER JOIN Exportaciones_DIAN ED ON (CL.nro_identificacion = ED.NIT3)
            INNER JOIN LU_MATRICULADO MAT ON (MAT.id_matriculado = CL.id_matriculado)
            LEFT JOIN lu_departamento_cliente H ON RIGHT(H.id_departamento_cliente, 2) = RIGHT(('1' + ED.DEPTO_PROCED), 2)
            LEFT JOIN lu_pais_cliente K ON K.id_pais_cliente = ED.PAIS3
            LEFT JOIN SICO_CODIGOS_ARANCEL SA ON SA.ID_ARANCEL = ED.POS_ARA3
            WHERE CL.id_cliente = :idCliente
            AND CL.id_matriculado = MAT.id_matriculado
            AND ED.FECHA_DATOS BETWEEN DATEADD(YYYY, -5, :fechaActual) AND :fechaActual
    """, nativeQuery = true)
    List<ImportExportEntity> consultExportData(@Param("idCliente") String idCliente,@Param("fechaActual") Date fechaActual);
}

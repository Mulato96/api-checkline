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
public interface JpaImportRepository extends JpaRepository<ImportExportEntity, Long> {
    @Transactional
    @Query (value = """
    SELECT
      ID.razon_social_importador AS Nombre,
      ID.nit_del_importador AS Identificacion,
      K.desc_pais_cliente AS Origen,
      H.desc_departamento_cliente AS Destino,
      (ID.partida_arancelaria + ' : ' + ISNULL(SA.DESC_DETALLADA, 'No se encontro descripcion')) AS PosicionArancel,
      ID.peso_neto AS Peso,
      ID.cantidad + ID.unidad_comercial AS NumArticulos,
      ID.valor_cif_US AS Valor,
      CONVERT(DateTime, (SUBSTRING(ID.fecha_de_aceptacion, 1, 4) + '-' + SUBSTRING(ID.fecha_de_aceptacion, 5, 2) + '-' +
      CASE SUBSTRING(ID.fecha_de_aceptacion, 7, 2) WHEN '00' THEN '01' ELSE SUBSTRING(ID.fecha_de_aceptacion, 7, 2) END)) AS FECHA
    FROM
    LU_CLIENTE CL
    INNER JOIN
    Importaciones_DIAN ID ON CL.nro_identificacion = ID.nit_del_importador
    INNER JOIN
    LU_MATRICULADO MAT ON MAT.id_matriculado = CL.id_matriculado
    LEFT JOIN
    lu_pais_cliente K ON K.id_pais_cliente = ID.pais_procedencia
    LEFT JOIN
    lu_departamento_cliente H ON RIGHT(H.id_departamento_cliente, 2) = RIGHT(('1' + ID.departamento_de_destino), 2)
    LEFT JOIN
    SICO_CODIGOS_ARANCEL SA ON SA.ID_ARANCEL = ID.partida_arancelaria
    WHERE CL.id_cliente = :idCliente
    AND CL.id_matriculado = MAT.id_matriculado
    AND ID.fecha_datos BETWEEN DATEADD(year, -5, :fechaActual) AND :fechaActual
    """, nativeQuery = true)
    List<ImportExportEntity> consultImportData(@Param("idCliente") String idCliente, @Param("fechaActual") Date fechaActual);
}

package com.sico.api.checkinline.infraestructure.persistences.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.IdentificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaIdentificationRepository extends JpaRepository<IdentificationEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT id_matriculado, id_cliente, nombreCLIENTE nombre_matriculado, nromatricula as nro_matricula,
        DOCUMENTO desc_tipo_identificacion, NUMID nro_identificacion, DirComercial, Telefono, email,
        ISNULL(CONVERT(nvarchar(10),CONVERT(DATE,FecRenovacion)),'Sin Dato') AS FecRenovacion,
        C.desc_camara, OrganizacionJuridica, CiudadComercial, ActividadEconomica,
        FecMatricula, CiudadJudicial as Domicilio, UltimoAnoRenova, DirJudicial,
        CiudadJudicial, email_notif
        FROM coive_informacion_basica with (nolock)
        INNER JOIN lu_camaras_comercio C With (NoLock) On Camara_ComercioMatricula = C.id_camara
        WHERE id_matriculado = :numMatricula and id_cliente = :numId
        """, nativeQuery = true)
    IdentificationEntity getIdentificationSection(@Param("numMatricula") Long numMatricula, @Param("numId") Long numId);

    @Query(value = """
        select  NombreCliente  nombre_matriculado,
                DOCUMENTO desc_tipo_identificacion ,NUMID nro_identificacion,  c.desc_camara, NroMatricula nro_matricula,
                OrganizacionJuridica,
                CiudadJudicial Domicilio,
                ISNULL(CONVERT(nvarchar(10),CONVERT(DATE,FecRenovacion)),'Sin Dato') AS FecRenovacion,
                UltimoAnoRenova,
                DirJudicial,
                CiudadJudicial,
                email_notif,
                DirComercial,
                CiudadComercial,
                email,
                Telefono,
                ActividadEconomica
        from	coive_informacion_basica_oc  with (nolock)
        INNER JOIN lu_camaras_comercio c
        ON coive_informacion_basica_oc.id_camara = c.id_camara
        WHERE   NroMatricula = :numMatricula AND NUMID= :idCliente
        """, nativeQuery = true)
    IdentificationEntity getIdentificationSectionOC(@Param("numMatricula") String numMatricula,@Param("idCliente") Long idCliente);
}

package com.sico.api.checkinline.infraestructure.persistences.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaCertificasRepository extends JpaRepository<CertificasEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
            select D.ID_CERTIFICA , IB.id_matriculado, IB.nromatricula as nro_matricula, D.NOM_CERTIFICA,
            REPLACE(REPLACE(REPLACE(DBO.formatCertificadoNuevo(C.TXT_CERTIFICA), 'CERTIFICA :', ''), 'CERTIFICA:', ''), 'CERTIFICADO:', '') AS TXTCERTIFICA
            from coive_informacion_basica IB
            inner join CCBDW.DBO.FT_CERTIFICAS C With(NoLock)
            on IB.id_matriculado = C.id_matriculado
            Inner Join CCBDW.DBO.DES_CERTIFICA D With(NoLock)
            On C.id_certifica = D.ID_CERTIFICA
            WHERE IB.id_cliente= :idCliente
            """, nativeQuery = true)
    List<CertificasEntity> consultCertificas(@Param("idCliente") String idCliente);

    @Transactional(readOnly = true)
    @Query(value = """
            SELECT D.ID_CERTIFICA, C.TXTCERTIFICA, D.NOM_CERTIFICA
            FROM (
                SELECT *
                FROM coive_informacion_basica_oc
                WHERE NumId =  :numId
                  AND NroMatricula = :numMatricula
            ) IB
            INNER JOIN CCBDW.DBO.CCUNION_CT C ON C.NUM_MATRICULA = IB.NroMatricula
            INNER JOIN DES_CERTIFICA_NAL D ON CAST(C.CODCERTIFICA AS INT) = D.ID_CERTIFICA
            WHERE D.ID_CAMARA = IB.ID_CAMARA
            """, nativeQuery = true)
    List<CertificasEntity> consultCertificasOC(@Param("numId") String numId, @Param("numMatricula") String numMatricula);
}

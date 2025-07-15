package com.sico.api.checkinline.infraestructure.persistences.laft;

import com.sico.api.checkinline.domain.entities.laft.LinkedPersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaLinkedPersonRepository extends JpaRepository<LinkedPersonEntity, Long> {

    @Query(value = "SELECT DISTINCT " +
            "ma.nro_matricula AS registrationNumber, " +
            "cl.nombre_cliente AS linkedPersonName, " +
            "ti.desc_tipo_identificacion AS identificationType, " +
            "CAST(cl.nro_identificacion AS BIGINT) AS identificationNumber, " +
            "TRIM(ISNULL(c.Des_Cargo, tv.desc_tipo_vinculo)) AS position " +
            "FROM lu_vinculados v WITH (NOLOCK)" +
            "INNER JOIN lu_cliente cl WITH (NOLOCK) ON cl.id_cliente = v.id_cliente_vinculador " +
            "INNER JOIN lu_matriculado ma WITH (NOLOCK) ON ma.id_matriculado = v.id_matriculado " +
            "INNER JOIN TBL_VE_LAFT_CodigosVinculos_X_Tipo_Sociedad cod WITH (NOLOCK) " +
            "ON cod.Id_Vinculo = v.id_tipo_vinculo AND cod.id_tipo_sociedad = ma.id_tipo_sociedad " +
            "LEFT JOIN lu_Cargos c WITH (NOLOCK) ON CONVERT(nvarchar(5), c.Id_Cargo) = SUBSTRING(v.id_cargo, 3, 4) " +
            "LEFT JOIN lu_tipo_vinculo tv WITH (NOLOCK) ON tv.id_tipo_vinculo = v.id_tipo_vinculo " +
            "INNER JOIN lu_tipo_identificacion ti WITH (NOLOCK) ON ti.id_tipo_identificacion = cl.id_tipo_identificacion " +
            "WHERE ma.nro_matricula = :registrationNumber AND cod.Valor = 3 " +
            "ORDER BY linkedPersonName ASC",
            countQuery = "SELECT COUNT(DISTINCT v.id_cliente_vinculador) " +
                    "FROM lu_vinculados v WITH (NOLOCK)" +
                    "INNER JOIN lu_cliente cl WITH (NOLOCK) ON cl.id_cliente = v.id_cliente_vinculador " +
                    "INNER JOIN lu_matriculado ma WITH (NOLOCK) ON ma.id_matriculado = v.id_matriculado " +
                    "INNER JOIN TBL_VE_LAFT_CodigosVinculos_X_Tipo_Sociedad cod WITH (NOLOCK) " +
                    "ON cod.Id_Vinculo = v.id_tipo_vinculo AND cod.id_tipo_sociedad = ma.id_tipo_sociedad " +
                    "WHERE ma.nro_matricula = :registrationNumber AND cod.Valor = 3",
            nativeQuery = true)
    Page<LinkedPersonEntity> findLinkedPersonsByRegistrationNumber(@Param("registrationNumber") String registrationNumber, Pageable pageable);
}

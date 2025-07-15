package com.sico.api.checkinline.infraestructure.persistences.laft;

import com.sico.api.checkinline.domain.entities.laft.LinkedPersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaLinkedPersonOCRepository extends JpaRepository<LinkedPersonEntity, Long> {

    @Query(value = "SELECT DISTINCT " +
            "cl.NUM_MATRICULA AS registrationNumber, " +
            "cl.VIN_NOMBRE AS linkedPersonName, " +
            "ti.desc_tipo_identificacion AS identificationType, " +
            "CAST(cl.VIN_NUM_ID AS BIGINT) AS identificationNumber, " +
            "cl.CARGO AS position " +
            "FROM CCUNION_VN cl WITH (NOLOCK) " +
            "INNER JOIN CCUNION_RM R WITH (NOLOCK) ON cl.ID_CAMARA = R.ID_CAMARA AND cl.NUM_MATRICULA = R.NUM_MATRICULA " +
            "INNER JOIN TBL_VE_LAFT_CodigosVinculos_X_Tipo_Sociedad V WITH (NOLOCK) ON R.tipo_sociedad = V.id_tipo_sociedad AND cl.COD_VINCULO = V.id_Vinculo " +
            "INNER JOIN lu_tipo_identificacion ti WITH (NOLOCK) ON ti.id_tipo_identificacion = cl.VIN_TIPO_ID " +
            "WHERE V.Valor = 3 AND cl.NUM_MATRICULA = :registrationNumber AND cl.ID_CAMARA = :idChamber " +
            "ORDER BY linkedPersonName ASC",
            countQuery = "SELECT COUNT(DISTINCT cl.NUM_MATRICULA) " +
                    "FROM CCUNION_VN cl WITH (NOLOCK) " +
                    "INNER JOIN CCUNION_RM R WITH (NOLOCK) ON cl.ID_CAMARA = R.ID_CAMARA AND cl.NUM_MATRICULA = R.NUM_MATRICULA " +
                    "INNER JOIN TBL_VE_LAFT_CodigosVinculos_X_Tipo_Sociedad V WITH (NOLOCK) ON R.tipo_sociedad = V.id_tipo_sociedad AND cl.COD_VINCULO = V.id_Vinculo " +
                    "WHERE V.Valor = 3 AND cl.NUM_MATRICULA = :registrationNumber AND cl.ID_CAMARA = :idChamber",
            nativeQuery = true)
    Page<LinkedPersonEntity> findLinkedPersonsByRegistrationNumberAndIdChamber(
            @Param("registrationNumber") String registrationNumber,
            @Param("idChamber") Long idChamber,
            Pageable pageable);
}
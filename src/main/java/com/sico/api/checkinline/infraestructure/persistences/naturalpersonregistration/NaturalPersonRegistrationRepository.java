package com.sico.api.checkinline.infraestructure.persistences.naturalpersonregistration;

import com.sico.api.checkinline.domain.entities.naturalpersonregistration.NaturalPersonRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NaturalPersonRegistrationRepository extends JpaRepository<NaturalPersonRegistrationEntity, Long> {

    @Query(value = """
             SELECT
                    MT.nombre_matriculado AS registeredName,
                    CL.id_tipo_identificacion AS identificationTypeId,
                    CL.nro_identificacion AS identificationNumber,
                    CL.digito_verificacion AS verificationDigit,
                    MT.fecha_matricula AS registrationDate,
                    MT.nro_matricula AS registrationNumber,
                    DIR.dir_notif AS notificationAddress,
                    DIR.ciudad_notif AS notificationCity,
                    DIR.dir_comercial AS commercialAddress,
                    DIR.desc_ciudad_comercial AS commercialCityDescription,
                    DIR.email_comercial AS commercialEmail,
                    MT.fecha_ultima_renovacion_matricula AS lastRenewalDate,
                    MT.id_ultimo_ano_renovado AS lastRenewedYearId,
                    ISNULL(EF.vlr_tot_pasi,0) AS totalLiabilities,
                    STRING_AGG(CONCAT(RTRIM(ACT.id_ae_nivel4), '-', ACT.desc_ae_nivel4), ', ') AS activityDescriptionLevel4,
                    RGM.desc_regimen_iva AS taxRegimeDescription
             FROM
                    lu_cliente CL
                INNER JOIN
                    lu_matriculado MT ON CL.id_cliente = MT.id_cliente
                INNER JOIN
                    Ft_his_estados_financieros EF ON MT.id_matriculado = EF.id_matriculado
                INNER JOIN
                    lu_cliente_complemento DIR ON CL.id_cliente = DIR.id_cliente
                LEFT JOIN
                    lu_matriculado_ae AE ON AE.id_matriculado = CL.id_matriculado
                LEFT JOIN
                    lu_ae_nivel4 ACT ON AE.id_ae_nivel4_1 = ACT.id_ae_nivel4
                LEFT JOIN
                    lu_regimen_iva RGM ON MT.id_regimen_iva = RGM.id_regimen_iva
                WHERE
                    MT.nro_matricula = :registrationNumber
                    AND EF.id_dato_valido = 2
                    AND MT.id_tipo_sociedad = 1
                GROUP BY
                        MT.nombre_matriculado,
                        CL.id_tipo_identificacion,
                        CL.nro_identificacion,
                        CL.digito_verificacion,
                        MT.fecha_matricula,
                        MT.nro_matricula,
                        DIR.dir_notif,
                        DIR.ciudad_notif,
                        DIR.dir_comercial,
                        DIR.desc_ciudad_comercial,
                        DIR.email_comercial,
                        MT.fecha_ultima_renovacion_matricula,
                        MT.id_ultimo_ano_renovado,
                        EF.vlr_tot_pasi,
                        RGM.desc_regimen_iva;
        """, nativeQuery = true)
    List<NaturalPersonRegistrationEntity> findNaturalPersonRegistration(@Param("registrationNumber") String registrationNumber);

    @Query(value = """
                    SELECT
                            CCR_RM.RAZON_SOCIAL AS registeredName,
                            CCR_RM.TIPO_ID AS identificationTypeId,
                            CCR_RM.NUM_ID AS identificationNumber,
                            CCR_RM.DV AS verificationDigit,
                            CCR_RM.FEC_MATRICULA AS registrationDate,
                        	CCR_RM.NUM_MATRICULA AS registrationNumber,
                        	CCR_RM.DIRECCION AS notificationAddress,
                        	CCR_RM.DIRECCION AS commercialAddress,
                        	CCR_RM.EMAIL AS commercialEmail,
                        	CCR_RM.FEC_RENOVACION AS lastRenewalDate,
                        	CCR_RM.ULTIMO_ANO_REN AS lastRenewedYearId,
                        	ISNULL(CCU_RMFN.VRTOTPASI, 0) AS totalLiabilities,
                        	CCR_RM.ACTIVIDAD AS activityDescriptionLevel4,
                        	'' AS taxRegimeDescription,
                        	 PTM.NOM_MUNICIPIO AS notificationCity,
                        	 PTM.NOM_MUNICIPIO AS commercialCityDescription
                        FROM
                        	CCUNION_RM CCR_RM
                        INNER JOIN CCUNION_RM_FIN CCU_RMFN on CCR_RM.ID_CAMARA = CCU_RMFN.ID_CAMARA AND CCR_RM.NUM_MATRICULA = CCU_RMFN.NUM_MATRICULA
                        JOIN PR_TA_MUNICIPIOS ptm ON PTM.ID_MUNICIPIO = COD_MUNICIPIO
                        WHERE
                        	CCR_RM.TIPO_SOCIEDAD = 1 AND CCR_RM.NUM_MATRICULA = :registrationNumber AND CCR_RM.ID_CAMARA = :chamberId
    
                  """, nativeQuery = true)
    List<NaturalPersonRegistrationEntity> findNaturalPersonRegistrationOtherChamberCommerce(@Param("registrationNumber") String registrationNumber, @Param("chamberId") String chamberId);

}

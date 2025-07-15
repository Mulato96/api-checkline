package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.CompanySearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaCompanySearchRepository extends JpaRepository<CompanySearchEntity, String> {

    @Transactional(readOnly = true)
    @Query(value = """
            SELECT DISTINCT CAST(CL.id_cliente AS VARCHAR(50)) IdEmpresa,
                CAST(1 AS BIT) AS EsBogota,
                ISNULL(CL.nro_identificacion, '') AS Identificacion,
                ISNULL(CL.nombre_cliente, '') AS NombreRazonSocial,
                ISNULL(CL.Sigla, '') AS Sigla,
                ISNULL(EM.[desc_estado_matricula], '') AS EstadoMatricula,
                M.nro_matricula AS Matricula,
                CASE WHEN CC.[desc_ciudad_comercial] IS NULL
                THEN 'SIN CIUDAD'
                ELSE CC.[desc_ciudad_comercial] END AS CiudadDepartamento,
                CASE WHEN M.id_tipo_sociedad = 2 THEN 'Establecimiento de comercio'
                ELSE ISNULL(CA.[desc_categoria], '') END AS Categoria,
                ISNULL((SELECT TOP(1) TE.[NOM_TAMANO]
                        FROM [IND_TAMANO_EMPRESAS_ANO_UVT] TE
                        WHERE TE.[ANO_DATOS] = ISNULL(M.id_ultimo_ano_renovado,'')
                        AND TE.[ID_SECTOR] = ISNULL ((SELECT TOP(1) TT.[ID_SECTOR]
                                                      FROM [ccbcontrol].[dbo].[TA_CIIU] TT
                                                      WHERE TT.[ID_CIIU] = ISNULL(CIIU.[id_ae_nivel4_1],'')),'B001')
                                                      AND ISNULL(EF.[VLR_ING_ACTIV_ORDINARIA], 0) BETWEEN TE.[VR_RANGO_INI] AND TE.[VR_RANGO_FIN]),
                                                      CASE WHEN EF.[vlr_tot_acti_brutos] BETWEEN 0 AND 439418582 THEN 'Microempresas'
                                                      WHEN EF.[vlr_tot_acti_brutos] BETWEEN 439418583 AND 4386292082 THEN 'Pequeñas'
                                                      WHEN EF.[vlr_tot_acti_brutos] BETWEEN 4386292083 AND 26313367082 THEN 'Medianas'
                                                      WHEN EF.[vlr_tot_acti_brutos] >= 26313367083 THEN 'Grandes'
                                                      ELSE 'Sin Clasificar' END) AS Tamanio,
                ISNULL((SELECT TOP(1) W.[desc_ae_seccion] FROM [VW_CIIU4] W WHERE W.[id_ae_nivel4] = CIIU.[id_ae_nivel4_1]),'') AS Sector,
                ISNULL(CC.[dir_comercial], '') AS Direccion,
                M.id_matriculado as Matriculado,
                V.ID_CAMARA AS Camara
                FROM [CC_VALIDADOR] AS V WITH(NOLOCK)
                JOIN [lu_matriculado] AS M WITH(NOLOCK) ON V.[NUM_MATRICULA] = M.[nro_matricula] AND V.[CTR_VALIDO] = 1 AND V.[ID_CAMARA] = 4
                JOIN [lu_cliente] AS CL WITH(NOLOCK) ON CL.[id_cliente] = M.[id_cliente] AND CL.[nro_identificacion] IS NOT NULL AND CL.[nro_identificacion] <> ''
                JOIN [lu_estado_matricula] AS EM WITH(NOLOCK) ON M.id_estado_matricula = EM.[id_estado_matricula]
                JOIN [lu_categoria] AS CA WITH(NOLOCK) ON M.id_categoria = CA.[id_categoria]
                LEFT JOIN [lu_cliente_complemento] AS CC WITH(NOLOCK) ON CL.id_cliente = CC.[id_cliente]
                LEFT JOIN [ft_his_estados_financieros] AS EF WITH(NOLOCK) ON EF.[id_matriculado] = M.id_matriculado AND EF.[id_dato_valido] = 2
                LEFT JOIN [lu_matriculado_ae] CIIU WITH(NOLOCK) ON M.id_matriculado = CIIU.[id_matriculado]
                WHERE 1 = 1
                AND (:registrationFilter = 0 OR M.nro_matricula =:informationGeneralForm)
                AND (:identificationFilter = 0 OR CL.nro_identificacion =:informationGeneralForm)
                AND (:corporateNameInitialsFilter = 0 OR CL.nombre_cliente LIKE CONCAT('%', :informationGeneralForm, '%'))
            """, nativeQuery = true)
    List<CompanySearchEntity> checkOutCompaniesBogotaSearch(
            @Param("registrationFilter") Integer registrationFilter,
            @Param("informationGeneralForm") String informationGeneralForm,
            @Param("identificationFilter") Integer identificationFilter,
            @Param("corporateNameInitialsFilter") Integer corporateNameInitialsFilter);


    @Transactional(readOnly = true)
    @Query(value = """
                SELECT DISTINCT CAST(T.id_registro AS VARCHAR(50)) IdEmpresa,
                	CAST(0 AS BIT) AS EsBogota,
                	T.NUM_ID AS Identificacion,
                	T.RAZON_SOCIAL AS NombreRazonSocial,
                	ISNULL(T.[SIGLA], '') AS Sigla,
                	ISNULL(EM.[desc_estado_matricula], '') as EstadoMatricula,
                	T.NUM_MATRICULA AS Matricula,
                	CASE WHEN CCL.[desc_ciudad_cliente] IS NULL THEN 'SIN CIUDAD'
                	ELSE CCL.[desc_ciudad_cliente] END AS CiudadDepartamento,
                	CASE WHEN T.TIPO_CATEGORIA = 2 THEN 'Establecimiento de comercio'
                	ELSE ISNULL(CA.[desc_categoria], '') END AS Categoria,
                	ISNULL((SELECT TOP(1) TE.[NOM_TAMANO]
                		    FROM [IND_TAMANO_EMPRESAS_ANO_UVT] TE
                			WHERE TE.[ANO_DATOS] = ISNULL(T.ULTIMO_ANO_REN ,'')
                			AND TE.[ID_SECTOR] = ISNULL ((SELECT TOP(1) TT.[ID_SECTOR]
                			   							  FROM [ccbcontrol].[dbo].[TA_CIIU] TT
                			   							  WHERE TT.[ID_CIIU] = ISNULL(SUBSTRING(T.CIIU1,2,5),'')), 'B001')
                			   							  AND ISNULL([VRVENTASNETAS],0) BETWEEN TE.[VR_RANGO_INI] AND TE.[VR_RANGO_FIN]),
                			   							  CASE WHEN [VRTOTACTIBRUTOS] BETWEEN 0 AND 439418582 THEN 'Microempresas'
                			   							  WHEN [VRTOTACTIBRUTOS] BETWEEN 439418583 AND 4386292082 THEN 'Pequeñas'
                			   							  WHEN [VRTOTACTIBRUTOS] BETWEEN 4386292083 AND 26313367082 THEN 'Medianas'
                			   							  WHEN [VRTOTACTIBRUTOS] >= 26313367083 THEN 'Grandes'
                			   							  ELSE 'Sin Clasificar' END) AS Tamanio,
                		ISNULL(CASE SUBSTRING(T.CIIU1 , 1, 1)
                				WHEN 'A' THEN 'Agricultura, ganadería, caza y silvicultura'
                				WHEN 'B' THEN 'Explotación de minas y canteras'
                				WHEN 'C' THEN 'Industrias manufactureras'
                				WHEN 'D' THEN 'Suministro de electricidad, gas, vapor y aire acondicionado'
                				WHEN 'E' THEN 'Distribución de agua; evacuación y tratamiento de aguas residuales, gestión'
                				WHEN 'F' THEN 'Construcción'
                				WHEN 'G' THEN 'Comercio al por mayor y al por menor; reparación de vehículos automotores y motocicletas'
                				WHEN 'H' THEN 'Transporte y almacenamiento'
                				WHEN 'I' THEN 'Alojamiento y servicios de comida'
                				WHEN 'J' THEN 'Información y comunicaciones'
                				WHEN 'K' THEN 'Actividades financieras y de seguros'
                				WHEN 'L' THEN 'Actividades inmobiliarias'
                				WHEN 'M' THEN 'Actividades profesionales, científicas y técnicas'
                				WHEN 'N' THEN 'Actividades de servicios administrativos y de apoyo'
                				WHEN 'O' THEN 'Administración pública y defensa; planes de seguridad social de afiliación obligatoria'
                				WHEN 'P' THEN 'Educación'
                				WHEN 'Q' THEN 'Actividades de atención de la salud humana y de asistencia social'
                				WHEN 'R' THEN 'Actividades artísticas, de entretenimiento y recreación'
                				WHEN 'S' THEN 'Otras actividades de servicios'
                				WHEN 'T' THEN 'Actividades de los hogares en calidad de empleadores; actividades no diferenciadas de los hogares individuales como productores de bienes y servicios para uso propio'
                				WHEN 'U' THEN 'Actividades de organizaciones y entidades extraterritoriales'
                				ELSE NULL END, ''
                			) AS Sector,
                		ISNULL(T.[DIRECCION], '') AS Direccion,
                        T.NUM_ID AS Matriculado,
                		T.ID_CAMARA AS Camara
                FROM [CC_VALIDADOR] AS V WITH(NOLOCK)
                JOIN [CCUNION_RM] AS T WITH(NOLOCK) ON V.[NUM_MATRICULA] = T.[NUM_MATRICULA] AND V.[CTR_VALIDO] = 1 AND V.[ID_CAMARA] = T.[ID_CAMARA] AND T.[NUM_ID] IS NOT NULL AND T.[NUM_ID] <> ''''
                LEFT JOIN [lu_estado_matricula] AS EM WITH(NOLOCK) ON T.ESTADO = EM.[id_estado_matricula]
                LEFT JOIN [lu_camaras_comercio] AS CC WITH(NOLOCK) ON T.ID_CAMARA = CC.[ID_CAMARA]
                LEFT JOIN [lu_categoria] AS CA WITH(NOLOCK) ON T.TIPO_CATEGORIA = CA.[id_categoria]
                LEFT JOIN [lu_ciudad_cliente] AS CCL WITH(NOLOCK) ON T.COD_MUNICIPIO = CCL.[id_ciudad_cliente]
                LEFT JOIN [CCUNION_RM_FIN] AS EF WITH(NOLOCK) ON EF.[NUM_MATRICULA] = T.NUM_MATRICULA AND EF.[ID_CAMARA] = T.ID_CAMARA 
                WHERE 1 = 1                
                AND (:registrationFilter = 0 OR T.NUM_MATRICULA =:informationGeneralForm)
                AND (:identificationFilter = 0 OR T.NUM_ID =:informationGeneralForm)
                AND (:corporateNameInitialsFilter = 0 OR T.RAZON_SOCIAL LIKE CONCAT('%', :informationGeneralForm, '%'))
            """, nativeQuery = true)
    List<CompanySearchEntity> checkOutCompaniesNationalSearch(
            @Param("registrationFilter") Integer registrationFilter,
            @Param("informationGeneralForm") String informationGeneralForm,
            @Param("identificationFilter") Integer identificationFilter,
            @Param("corporateNameInitialsFilter") Integer corporateNameInitialsFilter);

}

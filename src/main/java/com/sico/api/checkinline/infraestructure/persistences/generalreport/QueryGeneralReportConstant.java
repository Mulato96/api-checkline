package com.sico.api.checkinline.infraestructure.persistences.generalreport;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueryGeneralReportConstant {

  public static final String QUERY_CHECKOUT_GENERAL_INFORMATION_BOGOTA = """
      SELECT TOP 1
        CAST(C.[id_cliente] AS VARCHAR(50)) AS IdEmpresa,
        ISNULL(M.[nombre_matriculado], '') AS RazonSocial,
        ISNULL(UPPER(TI.[desc_tipo_identificacion]), 'OTRO') AS TipoIdentificacion,
        ISNULL(C.[nro_identificacion], '') AS Identificacion,
        ISNULL(M.[nro_matricula], '') AS Matricula,
        ISNULL(C.[sigla], '') AS Sigla,
        ISNULL(TS.[desc_tipo_sociedad], 'SIN DATO') AS OrganizacionJuridica,
        '04 - BOGOTA' AS Camara,
        ISNULL(EM.[desc_estado_matricula], '') AS EstadoMatricula,
        ISNULL(CONVERT(VARCHAR, M.[fecha_matricula], 103), '') FechaMatricula,
        ISNULL(CONVERT(VARCHAR, M.[fecha_ultima_renovacion_matricula], 103), '') AS FechaRenovacion,
        ISNULL(M.[id_ultimo_ano_renovado], 0) AS UltimoAnioRenovado,
        ISNULL(CONVERT(VARCHAR, M.[id_fecha_cancelacion], 103), 'No cancelada') AS FechaCancelacion,
        ISNULL(E.[desc_embargo], '') AS Embargo,
        ISNULL(CO.[desc_concordato], '') AS Concordato,
        ISNULL(CC.[dir_comercial], ISNULL(CC.[dir_comercial_standar], '')) AS DireccionComercial,
        ISNULL(CC.[departamento_comercial], '') AS DepartamentoComercial,
        ISNULL(CC.[desc_ciudad_comercial], '') AS CiudadComercial,
        ISNULL(CAST(CC.[id_sub_zona_postal_comercial] AS VARCHAR(10)), '') AS CodigoPostalComercial,
        ISNULL(CC.[tel1_comercial], ISNULL(CC.[tel2_comercial], '')) AS TelefonoComercial,
        CASE
          WHEN UPPER(CC.[email_comercial]) NOT LIKE '%@%' THEN 'No reporto'
          WHEN UPPER(CC.[email_comercial]) LIKE '%@%@%' THEN 'No reporto'
          WHEN UPPER(CC.[email_comercial]) LIKE '.%' THEN 'No reporto'
          WHEN UPPER(CC.[email_comercial]) LIKE '%.' THEN 'No reporto'
          WHEN UPPER(CC.[email_comercial]) LIKE '%?%' THEN 'No reporto'
          WHEN UPPER(CC.[email_comercial]) LIKE '%''%' THEN 'No reporto'
          WHEN UPPER(CC.[email_comercial]) LIKE '%"%' THEN 'No reporto'
          ELSE UPPER(ISNULL(CC.[email_comercial], 'No reporto')) END AS CorreoComercial,
        ISNULL(CC.[aa_comercial], '') AS AAComercial,
        ISNULL(TRIM(CC.[pagina_web_comercial]), '') AS DireccionWebComercial,
        ISNULL(TRIM(CC.[fax_comercial]), '') AS FaxComercial,
       
       
        ISNULL(CC.[dir_notif], '') AS DireccionJudicial,
        ISNULL(CC.[departamento_notif], '') AS DepartamentoJudicial,
        ISNULL(CC.[ciudad_notif], '') AS CiudadJudicial,
        ISNULL(CAST(CC.[id_sub_zona_postal_notif] AS VARCHAR(10)), '') AS CodigoPostalJudicial,
        ISNULL(CC.[tel1_notif], ISNULL(CC.[tel2_notif], '')) AS TelefonoJudicial,
        CASE
          WHEN UPPER(CC.[email_notif]) NOT LIKE '%@%' THEN 'No reporto'
          WHEN UPPER(CC.[email_notif]) LIKE '%@%@%' THEN 'No reporto'
          WHEN UPPER(CC.[email_notif]) LIKE '.%' THEN 'No reporto'
          WHEN UPPER(CC.[email_notif]) LIKE '%.' THEN 'No reporto'
          WHEN UPPER(CC.[email_notif]) LIKE '%?%' THEN 'No reporto'
          WHEN UPPER(CC.[email_notif]) LIKE '%''%' THEN 'No reporto'
          WHEN UPPER(CC.[email_notif]) LIKE '%"%' THEN 'No reporto'
          ELSE ISNULL(UPPER(CC.[email_notif]), 'No reporto') END CorreoJudicial,
        ISNULL(CC.[aa_notif], '') AS AAJudicial,
        ISNULL(TRIM(CC.[pagina_web_notif]), '') AS DireccionWebJudicial,
        ISNULL(TRIM(CC.[fax_notif]), '') AS FaxJudicial,
       
        ISNULL(CC.[punto_x_comercial], '') AS Longitud,
        ISNULL(CC.[punto_y_comercial], '') AS Latitud ,
        ISNULL(C1.[COD_CIIU], '') AS CIIU1,
        ISNULL(C1.[desc_ae_nivel4], '') AS DescripcionCIIU1,
        ISNULL(C2.[COD_CIIU], '') AS CIIU2,
        ISNULL(C2.[desc_ae_nivel4], '') AS DescripcionCIIU2,
        ISNULL(C3.[COD_CIIU], '') AS CIIU3,
        ISNULL(C3.[desc_ae_nivel4], '') AS DescripcionCIIU3,
        ISNULL(C4.[COD_CIIU], '') AS CIIU4,
        ISNULL(C4.[desc_ae_nivel4], '') AS DescripcionCIIU4,
        ISNULL(OS.[txt_certifica], '') AS ObjetoSocial,
        CONCAT(ISNULL(RL1.[txt_certifica], ''), ' ', ISNULL(RL2.[txt_certifica], '')) AS FalcultadesRepresentanteLegal,
        ISNULL((SELECT TE.[NOM_TAMANO] FROM [IND_TAMANO_EMPRESAS_ANO_UVT] TE
                  WHERE TE.[ANO_DATOS] = ISNULL(M.[id_ultimo_ano_renovado], '')
                  AND TE.[ID_SECTOR] = ISNULL ((
                      SELECT TT.[ID_SECTOR] FROM [ccbcontrol].[dbo].[TA_CIIU] TT
                      WHERE TT.[ID_CIIU] = ISNULL(MA.[id_ae_nivel4_1], '')), 'B001')
              AND ISNULL(EF.[VLR_ING_ACTIV_ORDINARIA], 0) BETWEEN TE.[VR_RANGO_INI]
              AND TE.[VR_RANGO_FIN]),
          CASE WHEN EF.[vlr_tot_acti_brutos] BETWEEN 0
          AND 439418582 THEN 'Microempresas' WHEN EF.[vlr_tot_acti_brutos] BETWEEN 439418583
          AND 4386292082 THEN 'Pequeñas' WHEN EF.[vlr_tot_acti_brutos] BETWEEN 4386292083
          AND 26313367082 THEN 'Medianas' WHEN EF.[vlr_tot_acti_brutos] >= 26313367083 THEN 'Grandes' ELSE 'Sin Clasificar' END
        ) AS TamanioEmpresa,
      	ISNULL(CASE M.[id_regimen_iva]
              WHEN 0 THEN 'SIN REGIMEN'
              WHEN 1 THEN 'REGIMEN COMUN'
              WHEN 2 THEN 'REGIMEN SIMPLIFICADO'
              ELSE 'SIN REGIMEN'
              END, 'SIN REGIMEN') AS TipoRegimen,
      	ISNULL(LCAT.[desc_categoria], '') as Categoria,
      	ISNULL(CONVERT(nvarchar(10),CONVERT(DATE,CAP.[ID_FECHA_DATOS])),'') AS FechaDatos,
      	ISNULL(CASE M.[ID_lIQUIDACION]
      		WHEN 0 THEN 'NO LIQUIDA'
      		WHEN 1 THEN 'EN LIQUIDACIÓN'
      		WHEN 2 THEN 'LIQUIDADA'
      		WHEN 'Nothing' THEN 'NO LIQUIDADA'
      		ELSE '' END, '') AS IndicadorLiquidacion,
      	ISNULL(C4.[desc_ae_nivel4], '') as DescripcionActividadEconomica,
      	ISNULL(CASE M.[ID_lIQUIDACION]
      		WHEN 0 THEN 'NO AFILIADO'
      		WHEN 1 THEN 'AFILIADO'
      		WHEN 'Nothing' THEN 'NO LIQUIDADA'
      		ELSE '' END ,'') AS EstadoAfilicacion,
      		M.[id_matriculado] AS MatriculaId
            
      FROM
        [lu_cliente] C WITH(NOLOCK)
        INNER JOIN [lu_matriculado] M WITH(NOLOCK) ON C.[id_cliente] = M.[id_cliente]
        LEFT JOIN [lu_cliente_complemento] CC WITH(NOLOCK) ON C.[id_cliente] = CC.[id_cliente]
        LEFT JOIN [ft_his_estados_financieros] AS EF WITH(NOLOCK) ON EF.[id_matriculado] = M.[id_matriculado] AND EF.[id_dato_valido] = 2
        LEFT JOIN [lu_tipo_identificacion] TI WITH(NOLOCK) ON C.[id_tipo_identificacion] = TI.[id_tipo_identificacion]
        LEFT JOIN [lu_tipo_sociedad] TS WITH(NOLOCK) ON M.[id_tipo_sociedad] = TS.[id_tipo_sociedad]
        LEFT JOIN [lu_estado_matricula] EM WITH(NOLOCK) ON M.[id_estado_matricula] = EM.[id_estado_matricula]
        LEFT JOIN [lu_embargo] E WITH(NOLOCK) ON M.[id_embargo] = E.[id_embargo]
        LEFT JOIN [lu_concordato] CO WITH(NOLOCK) ON M.[id_concordato] = CO.[id_concordato]
        LEFT JOIN [lu_matriculado_ae] MA WITH(NOLOCK) ON M.[id_matriculado] = MA.[id_matriculado]
        LEFT JOIN [VW_CIIU4] C1 WITH(NOLOCK) ON MA.[id_ae_nivel4_1] = C1.[id_ae_nivel4]
        LEFT JOIN [VW_CIIU4] C2 WITH(NOLOCK) ON MA.[id_ae_nivel4_2] = C2.[id_ae_nivel4]
        LEFT JOIN [VW_CIIU4] C3 WITH(NOLOCK) ON MA.[id_ae_nivel4_3] = C3.[id_ae_nivel4]
        LEFT JOIN [VW_CIIU4] C4 WITH(NOLOCK) ON MA.[id_ae_nivel4_4] = C4.[id_ae_nivel4]
        LEFT JOIN [ft_certificas] OS WITH(NOLOCK) ON C.[id_cliente] = OS.[id_cliente] AND OS.[id_certifica] = 740
        LEFT JOIN [ft_certificas] RL1 WITH(NOLOCK) ON C.[id_cliente] = RL1.[id_cliente] AND RL1.[id_certifica] = 1300
        LEFT JOIN [ft_certificas] RL2 WITH(NOLOCK) ON C.[id_cliente] = RL2.[id_cliente] AND RL2.[id_certifica] = 1301
        LEFT JOIN [lu_categoria] LCAT WITH(NOLOCK) ON C.[id_categoria] = LCAT.[id_categoria]
        LEFT JOIN [ft_his_capitales] CAP WITH(NOLOCK) ON EF.[id_matriculado] = CAP.[id_matriculado]
        LEFT JOIN [lu_afiliado] AFL WITH (NOLOCK) ON EF.[id_matriculado] = AFL.[id_matriculado]
      WHERE C.[id_cliente] =:companyId         
      """;

  public static final String QUERY_CHECKOUT_GENERAL_INFORMATION_NO_BOGOTA = """
      SELECT
        TOP(1) CAST(C.[id_registro] AS VARCHAR(50)) AS IdEmpresa,
        ISNULL(C.[RAZON_SOCIAL], '') AS RazonSocial,
        ISNULL(UPPER(TI.[desc_tipo_identificacion]), 'OTRO') AS TipoIdentificacion,
        ISNULL([dbo].[COIFX_QUITAR_CEROS](TRIM(C.[NUM_ID])), '') AS Identificacion,
        ISNULL(C.[NUM_MATRICULA], '') AS Matricula,
        ISNULL(C.[SIGLA], '') AS Sigla,
        ISNULL(TS.[desc_tipo_sociedad], '') AS OrganizacionJuridica,
        ISNULL(CONCAT(CASE LEN(C.[id_camara]) WHEN 1 THEN CONCAT('0', C.[id_camara]) ELSE '' END, ' - ', CC.[desc_camara]), '') AS Camara,
        ISNULL(EM.[desc_estado_matricula], '') AS EstadoMatricula,
        ISNULL(CONVERT(VARCHAR, C.[FEC_MATRICULA], 103), '') AS FechaMatricula,
        ISNULL(CONVERT(VARCHAR, C.[FEC_RENOVACION], 103), '') AS FechaRenovacion,
        ISNULL(C.[ULTIMO_ANO_REN], 0) AS UltimoAnioRenovado,
        ISNULL(CONVERT(VARCHAR, C.[FEC_CANCELA], 103), '') AS FechaCancelacion,
        ISNULL(E.[desc_embargo], '') AS Embargo,
        ISNULL(CO.[desc_concordato], '') AS Concordato,
        ISNULL(TRIM(C.[DIRECCION]), '') AS DireccionComercial,
        ISNULL(TRIM(DC.[desc_departamento_cliente]), '') AS DepartamentoComercial,
        ISNULL(TRIM(CCL.[desc_ciudad_cliente]), '') AS CiudadComercial,
        ISNULL(TRIM(C.[ZONA_POSTAL]), '') AS CodigoPostalComercial,
        ISNULL(TRIM(C.[TELEFONO1]), '') AS TelefonoComercial,
        CASE
              WHEN UPPER(C.[EMAIL]) NOT LIKE '%@%' THEN 'No reporto'
              WHEN UPPER(C.[EMAIL]) LIKE '%@%@%' THEN 'No reporto'
              WHEN UPPER(C.[EMAIL]) LIKE '.%' THEN 'No reporto'
              WHEN UPPER(C.[EMAIL]) LIKE '%.' THEN 'No reporto'
              WHEN UPPER(C.[EMAIL]) LIKE '%?%' THEN 'No reporto'
              WHEN UPPER(C.[EMAIL]) LIKE '%''%' THEN 'No reporto'
              WHEN UPPER(C.[EMAIL]) LIKE '%"%' THEN 'No reporto'
          ELSE UPPER(ISNULL(C.[EMAIL], 'No reporto'))
          END CorreoComercial, '' AS AAComercial,
        ISNULL(C.[WEB], '') AS DireccionWebComercial,
        '' AS DireccionJudicial,
        '' AS DepartamentoJudicial,
        '' AS CiudadJudicial,
        '' AS CodigoPostalJudicial,
        '' AS TelefonoJudicial,
        '' AS CorreoJudicial,
        '' AS AAJudicial,
        '' AS DireccionWebJudicial,
        '' AS Longitud,
        '' AS Latitud,
        ISNULL(C.[CIIU1], '') AS CIIU1,
        ISNULL(C1.[desc_ae_nivel4], '') AS DescripcionCIIU1,
        ISNULL(C.[CIIU2], '') AS CIIU2,
        ISNULL(C2.[desc_ae_nivel4], '') AS DescripcionCIIU2,
        ISNULL(C.[CIIU3], '') AS CIIU3,
        ISNULL(C3.[desc_ae_nivel4], '') AS DescripcionCIIU3,
        ISNULL(C.[CIIU4], '') AS CIIU4,
        ISNULL(C4.[desc_ae_nivel4], '') AS DescripcionCIIU4,
        ISNULL(OS.[TXTCERTIFICA], '') AS ObjetoSocial,
        CONCAT(ISNULL(RL1.[TXTCERTIFICA], ''), ' ', ISNULL(RL2.[TXTCERTIFICA], '')) AS FalcultadesRepresentanteLegal,
        ISNULL((
            SELECT TE.[NOM_TAMANO] FROM [IND_TAMANO_EMPRESAS_ANO_UVT] TE
            WHERE TE.[ANO_DATOS] = ISNULL(C.[ULTIMO_ANO_REN], '')
            AND TE.[ID_SECTOR] = ISNULL ((
                  SELECT TT.[ID_SECTOR]
                  FROM [ccbcontrol].[dbo].[TA_CIIU] TT
                  WHERE TT.[ID_CIIU] = ISNULL(SUBSTRING(C.[CIIU1], 2, 5), '')), 'B001'
      )
              AND ISNULL([VRVENTASNETAS], 0) BETWEEN TE.[VR_RANGO_INI]
              AND TE.[VR_RANGO_FIN]
          ),
          CASE WHEN [VRTOTACTIBRUTOS] BETWEEN 0
          AND 439418582 THEN 'Microempresas' WHEN [VRTOTACTIBRUTOS] BETWEEN 439418583
          AND 4386292082 THEN 'Pequeñas' WHEN [VRTOTACTIBRUTOS] BETWEEN 4386292083
          AND 26313367082 THEN 'Medianas' WHEN [VRTOTACTIBRUTOS] >= 26313367083 THEN 'Grandes' ELSE 'Sin Clasificar' END
        ) AS TamanioEmpresa
      FROM
        [CCUNION_RM] C WITH(NOLOCK)
        LEFT JOIN [CCUNION_RM_FIN] AS EF WITH(NOLOCK) ON EF.[NUM_MATRICULA] = C.[NUM_MATRICULA]
        AND EF.[ID_CAMARA] = C.[ID_CAMARA]
        LEFT JOIN [lu_tipo_identificacion] TI WITH(NOLOCK) ON C.[TIPO_ID] = TI.[id_tipo_identificacion]
        LEFT JOIN [lu_tipo_sociedad] TS WITH(NOLOCK) ON C.[TIPO_SOCIEDAD] = TS.[id_tipo_sociedad]
        LEFT JOIN [lu_camaras_comercio] CC WITH(NOLOCK) ON C.[ID_CAMARA] = CC.[id_camara]
        LEFT JOIN [lu_estado_matricula] EM WITH(NOLOCK) ON C.[ESTADO] = EM.[id_estado_matricula]
        LEFT JOIN [lu_embargo] E WITH(NOLOCK) ON C.[EMBARGO] = E.[id_embargo]
        LEFT JOIN [lu_concordato] CO WITH(NOLOCK) ON C.[CONCORDATO] = CO.[id_concordato]
        LEFT JOIN [lu_ciudad_cliente] CCL ON C.[COD_MUNICIPIO] = CCL.[id_ciudad_cliente]
        LEFT JOIN [lu_departamento_cliente] DC ON CCL.[id_departamento_cliente] = DC.id_departamento_cliente
        LEFT JOIN [lu_ae_nivel4] C1 WITH(NOLOCK) ON SUBSTRING(
          ISNULL(C.[CIIU1], ''),
          2,
          LEN(C.[CIIU1])
        ) = C1.[id_ae_nivel4]
        LEFT JOIN [lu_ae_nivel4] C2 WITH(NOLOCK) ON SUBSTRING(
          ISNULL(C.[CIIU2], ''),
          2,
          LEN(C.[CIIU2])
        ) = C2.[id_ae_nivel4]
        LEFT JOIN [lu_ae_nivel4] C3 WITH(NOLOCK) ON SUBSTRING(
          ISNULL(C.[CIIU3], ''),
          2,
          LEN(C.[CIIU3])
        ) = C3.[id_ae_nivel4]
        LEFT JOIN [lu_ae_nivel4] C4 WITH(NOLOCK) ON SUBSTRING(
          ISNULL(C.[CIIU4], ''),
          2,
          LEN(C.[CIIU4])
        ) = C4.[id_ae_nivel4]
        LEFT JOIN [CCUNION_CT] OS WITH(NOLOCK) ON C.[ID_CAMARA] = OS.[ID_CAMARA]
        AND C.[NUM_MATRICULA] = OS.[NUM_MATRICULA]
        AND OS.[CODCERTIFICA] = '0740'
        LEFT JOIN [CCUNION_CT] RL1 ON C.[ID_CAMARA] = OS.[ID_CAMARA]
        AND C.[NUM_MATRICULA] = OS.[NUM_MATRICULA]
        AND OS.[CODCERTIFICA] = '1300'
        LEFT JOIN [CCUNION_CT] RL2 ON C.[ID_CAMARA] = OS.[ID_CAMARA]
        AND C.[NUM_MATRICULA] = OS.[NUM_MATRICULA]
        AND OS.[CODCERTIFICA] = '1301'
      WHERE
        C.[id_registro] = :companyId
      """;
}

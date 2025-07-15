package com.sico.api.checkinline.infraestructure.persistences.PorposersReport;

import com.sico.api.checkinline.domain.entities.ProposersReport.OrganizationalCapacityReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaOrganizationalCapacityReportRepository extends JpaRepository<OrganizationalCapacityReportEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
        SELECT TOP 1
             CC.NUM_ID AS NIT,
             Y.NUM_PROPONENTE,
             (SELECT TOP 1 CO.VR_RENTABILIAD_PATRIMONIO
              FROM PR_CAPACIDAD_ORGANIZACIONAL CO WITH (NOLOCK)
              WHERE Y.NUM_PROPONENTE = CO.NUM_PROPONENTE
                AND CO.CTR_REGISTRO = 1) AS RENTABILIDAD_PATRIMONIO,
             (SELECT TOP 1 CO.VR_RENTABILIAD_ACTIVO
              FROM PR_CAPACIDAD_ORGANIZACIONAL CO WITH (NOLOCK)
              WHERE Y.NUM_PROPONENTE = CO.NUM_PROPONENTE
                AND CO.CTR_REGISTRO = 1) AS RENTABILIDAD_ACTIVO
         FROM dbo.PR_PROPONENTES Y WITH (NOLOCK)
         INNER JOIN dbo.PR_CC_CLIENTES CC WITH (NOLOCK)
             ON Y.NUM_CLIENTE = CC.NUM_CLIENTE
         WHERE CC.NUM_CLIENTE = :id
        """, nativeQuery = true)
    OrganizationalCapacityReportEntity consultOrganizationalCapacity(@Param("id") String id);
}

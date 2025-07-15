package com.sico.api.checkinline.infraestructure.persistences;

import static com.sico.api.checkinline.infraestructure.persistences.generalreport.QueryGeneralReportConstant.QUERY_CHECKOUT_GENERAL_INFORMATION_NO_BOGOTA;

import com.sico.api.checkinline.domain.entities.GeneralInformationEntity;
import com.sico.api.checkinline.infraestructure.persistences.generalreport.QueryGeneralReportConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaGeneralInformationRepository extends
    JpaRepository<GeneralInformationEntity, String> {

  @Transactional(readOnly = true)
  @Query(value = "EXEC PROC_SICO2_REPORTE_INFORMACION_GENERAL :companyId, :isBogota", nativeQuery = true)
  GeneralInformationEntity checkOutGeneralInformation(@Param("companyId") String companyId,
      @Param("isBogota") Boolean isBogota);

  @Transactional(readOnly = true)
  @Query(value = QueryGeneralReportConstant.QUERY_CHECKOUT_GENERAL_INFORMATION_BOGOTA, nativeQuery = true)
  GeneralInformationEntity checkOutGeneralInformationBogota(@Param("companyId") String companyId);

  @Transactional(readOnly = true)
  @Query(value = QUERY_CHECKOUT_GENERAL_INFORMATION_NO_BOGOTA, nativeQuery = true)
  GeneralInformationEntity checkOutGeneralInformationNoBogota(@Param("companyId") String companyId);


  @Query(value = """
      SELECT TOP 1 ISNULL(NRO_PERSONAL_OCUPADO, 0)
      FROM FT_HIS_ESTADOS_FINANCIEROS WITH (INDEX(IDX_DATO_VALIDO))
      WHERE ID_MATRICULADO = :matriculadoId AND ID_DATO_VALIDO = 2
      """, nativeQuery = true)
  Integer findEmployedStaffByRegisteredNumber(@Param("matriculadoId") String matriculadoId);
}

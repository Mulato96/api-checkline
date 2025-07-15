package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.RenewalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaRenewalRepository extends JpaRepository<RenewalEntity, String> {

  @Transactional(readOnly = true)
  @Query(value = "EXEC PROC_SICO2_REPORTE_RENOVACIONES :companyId", nativeQuery = true)
  List<RenewalEntity> checkOutRenewals(@Param("companyId") String companyId);

}

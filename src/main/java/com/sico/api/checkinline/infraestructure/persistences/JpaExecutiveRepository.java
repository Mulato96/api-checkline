package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.ExecutiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaExecutiveRepository extends JpaRepository<ExecutiveEntity, String> {

    @Transactional(readOnly = true)
    @Query(value = "EXEC PROC_SICO2_REPORTE_EJECUTIVOS :companyId, :isBogota", nativeQuery = true)
    List<ExecutiveEntity> checkOutExecutives(@Param("companyId") String companyId,
                                             @Param("isBogota") Boolean isBogota);

}

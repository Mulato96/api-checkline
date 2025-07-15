package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, String> {

  @Transactional(readOnly = true)
  @Query(value = "EXEC PROC_SICO2_REPORTE_EMPLEADOS_X_ANIO :companyId, :isBogota, :years", nativeQuery = true)
  List<EmployeeEntity> checkOutEmployees(@Param("companyId") String companyId, @Param("isBogota") Boolean isBogota,
                                         @Param("years") Integer years);

}

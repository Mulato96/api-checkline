package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.CompanySizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaCompanySizeRepository extends JpaRepository<CompanySizeEntity, String> {

    @Transactional(readOnly = true)
    @Query(value = "EXEC PROC_SICO2_REPORTE_TAMANIO_X_EMPRESAS_CIIU1 :companyId, :isBogota", nativeQuery = true)
    List<CompanySizeEntity> checkOutCompanySizes(@Param("companyId") String companyId,
                                                 @Param("isBogota") Boolean isBogota);

}

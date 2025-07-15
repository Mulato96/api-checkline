package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.CompanyBasicDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface JpaCompanyBasicDataRepository extends JpaRepository<CompanyBasicDataEntity, String> {
    @Transactional(readOnly = true)
    @Query(value = "EXEC COISP_DATOS_BASICOS :registeredId, :clientId", nativeQuery = true)
    CompanyBasicDataEntity getCompanyBasicData(Long registeredId, Long clientId);

    @Transactional(readOnly = true)
    @Query(value = "EXEC COISP_DATOS_BASICOS_OC :registeredId, :commerceId", nativeQuery = true)
    CompanyBasicDataEntity getCompanyBasicDataOC(String registeredId, Long commerceId);

}

package com.sico.api.checkinline.infraestructure.persistences.fiscalauditor;

import com.sico.api.checkinline.domain.entities.FiscalAuditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpaFiscalAuditorRepository extends JpaRepository<FiscalAuditorEntity, String> {
    @Transactional(readOnly = true)
    @Query(value = "EXEC COISP_REVISOR_FISCAL :clientId, :registeredId", nativeQuery = true)
    List<FiscalAuditorEntity> getFiscalAuditorData(Long clientId, Long registeredId);

}

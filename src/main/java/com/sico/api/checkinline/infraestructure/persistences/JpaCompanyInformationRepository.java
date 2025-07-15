package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.CompanyInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaCompanyInformationRepository extends JpaRepository<CompanyInformationEntity, String> {

    @Transactional(readOnly = true)
    @Query(value = "EXEC PROC_SICO2_DATASTORE_ID_REPORTE :documentNumber, :tuition", nativeQuery = true)
    CompanyInformationEntity companyInformation(@Param("documentNumber") String documentNumber,
                                                @Param("tuition") String tuition);
}

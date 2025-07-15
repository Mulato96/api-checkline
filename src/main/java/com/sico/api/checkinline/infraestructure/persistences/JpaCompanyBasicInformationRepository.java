package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.CompanyBasicInformationEntity;
import com.sico.api.checkinline.domain.entities.ImporterExporter.ImportExportEntity;
import com.sico.api.checkinline.domain.models.general.CompanyBasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface JpaCompanyBasicInformationRepository extends JpaRepository<CompanyBasicInformationEntity, Long> {
    @Transactional
    @Query(value = """
         SELECT c1_0.id_cliente, c1_0.id_matriculado
         FROM lu_cliente c1_0
         WHERE c1_0.id_cliente = :idCliente
    """, nativeQuery = true)
    CompanyBasicInformationEntity consultCompanyBasicInformation(@Param("idCliente") Long idCliente);
}

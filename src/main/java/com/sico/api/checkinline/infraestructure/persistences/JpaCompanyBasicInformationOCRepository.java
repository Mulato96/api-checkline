package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.CompanyBasicInformationEntity;
import com.sico.api.checkinline.domain.entities.CompanyBasicInformationOCEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCompanyBasicInformationOCRepository extends JpaRepository<CompanyBasicInformationOCEntity, String> {
    CompanyBasicInformationOCEntity findByIdentificationAndRegisteredId(String identification, String registeredId);
}

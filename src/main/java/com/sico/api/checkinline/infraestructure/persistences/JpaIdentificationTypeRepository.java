package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.IdentificationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaIdentificationTypeRepository extends
    JpaRepository<IdentificationTypeEntity, String> {

}

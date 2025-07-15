package com.sico.api.checkinline.infraestructure.persistences.legalrepresentation;

import com.sico.api.checkinline.domain.entities.legalrepresentation.CertificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpaCertificationsRepository extends JpaRepository<CertificationsEntity, Long> {
    @Transactional(readOnly = true)
    @Query(value = """
            select id_proponente, id_cliente from lu_cliente 
            where id_cliente = :idCliente
            """, nativeQuery = true)
    CertificationsEntity consultCertifications(@Param("idCliente") String idCliente);
}

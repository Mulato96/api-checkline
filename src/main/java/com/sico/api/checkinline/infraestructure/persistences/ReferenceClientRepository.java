package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.entities.ReferenceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceClientRepository extends JpaRepository<ReferenceEntity, String> {

  @Query(value = """
    SELECT 
      ROW_NUMBER() OVER (ORDER BY (SELECT 1)) AS Id,
      ISNULL(nom_referencia, '') AS NombreReferencia,
      ISNULL(tel_referencia, '') AS TelefonoReferencia,
      ISNULL(dir_referencia, '') AS DireccionReferencia
    FROM ft_referencias_clientes
    WHERE id_cliente = :companyId
    """, nativeQuery = true)
  List<ReferenceEntity> findReferencesByCompanyId(@Param("companyId") Integer companyId);
}

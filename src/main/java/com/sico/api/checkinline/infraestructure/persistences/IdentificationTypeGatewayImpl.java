package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.models.identificationtype.IdentificationType;
import com.sico.api.checkinline.domain.port.driver.IdentificationTypeGateway;
import com.sico.api.checkinline.infraestructure.mappers.IdentificationTypeMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdentificationTypeGatewayImpl implements IdentificationTypeGateway {

  private final JpaIdentificationTypeRepository jpaIdentificationTypeRepository;
  private final IdentificationTypeMapper identificationTypeMapper;

  @Override
  public List<IdentificationType> findAll() {
    return identificationTypeMapper.toDto(jpaIdentificationTypeRepository.findAll());
  }
}

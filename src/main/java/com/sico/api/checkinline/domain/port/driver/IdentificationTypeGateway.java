package com.sico.api.checkinline.domain.port.driver;

import com.sico.api.checkinline.domain.models.identificationtype.IdentificationType;
import java.util.List;

public interface IdentificationTypeGateway {

  List<IdentificationType> findAll();
}

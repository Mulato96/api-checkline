package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.domain.models.general.report.Reference;
import com.sico.api.checkinline.infraestructure.gateways.GeneralInformationGateway;
import com.sico.api.checkinline.domain.models.general.report.GeneralInformation;
import com.sico.api.checkinline.infraestructure.mappers.GeneralInformationMapper;
import com.sico.api.checkinline.infraestructure.mappers.ReferenceMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralInformationGatewayImpl implements GeneralInformationGateway {

  private final JpaGeneralInformationRepository repository;
  private final GeneralInformationMapper mapper;
  private final ReferenceMapper referenceMapper;
  private final ReferenceClientRepository referenceClientRepository;

  @Override
  public GeneralInformation checkOutGeneralInformation(String companyId, Boolean isBogota) {
    return mapper.toDto(
        repository.checkOutGeneralInformation(companyId, isBogota));
  }

  private GeneralInformation checkOutGeneralInformation_(String companyId, Boolean isBogota) {
    GeneralInformation generalInformation = mapper.toDto(
        repository.checkOutGeneralInformationBogota(companyId));
    generalInformation.setNumberOfEmployees(
        repository.findEmployedStaffByRegisteredNumber(generalInformation.getRegisterId())
            .toString());
    generalInformation.setReferences(
        validateReferences(referenceMapper.toDto(
            referenceClientRepository.findReferencesByCompanyId(Integer.valueOf(companyId)))));
    return generalInformation;
  }

  private List<Reference> validateReferences(List<Reference> references) {
    return references.stream().filter(
        value -> !value.getName().isEmpty() && !value.getAddress().isEmpty() && !value.getPhone()
            .isEmpty()).toList();
  }
}

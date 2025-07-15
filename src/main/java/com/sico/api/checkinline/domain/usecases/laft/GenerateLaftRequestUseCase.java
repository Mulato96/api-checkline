package com.sico.api.checkinline.domain.usecases.laft;

import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_CONTENT_ERROR_CONVERT_TO_JSON;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_CONTENT_SUCCESS_EMPTY;
import static java.util.Objects.nonNull;

import com.sico.api.checkinline.application.exceptions.VerificationLaftException;
import com.sico.api.checkinline.domain.models.laft.verification.LaftCustomerModel;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestEvent;
import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestExternal;
import com.sico.api.checkinline.domain.models.laft.verification.VerificationLaftResponse;
import com.sico.api.checkinline.domain.port.driver.laftverification.LaftVerificationGateway;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenerateLaftRequestUseCase {

  private final LaftVerificationGateway laftVerificationGateway;

  public void generate(List<VerificationLaftResponse> payload, Long idMailBox) {
    if (payload.isEmpty()){
      throw new VerificationLaftException(EXCEPTION_CONTENT_SUCCESS_EMPTY);
    }
    try {
      List<LaftRequestEvent> laftRequestEvents = payload.stream()
          .map(value -> {
            LaftCustomerModel laftCustomerModel = getNames(value);
            return LaftRequestEvent.builder()
                .identificationType(value.getIdentificationType())
                .companyName(laftCustomerModel.getCompanyName())
                .identificationTypeLabel(value.getIdentificationTypeLabel())
                .identificationNumber(value.getIdentificationNumber())
                .legalNature(value.getNatureLegalLabel())
                .firstName(laftCustomerModel.getFirstName())
                .firstLastName(laftCustomerModel.getLastFirstName())
                .build();
          }).toList();
      laftVerificationGateway.createRequest(LaftRequestExternal.builder()
          .laftRequestPayloads(laftRequestEvents)
          .idMailBox(idMailBox)
          .build());
    } catch (Exception ex) {
      throw new VerificationLaftException(EXCEPTION_CONTENT_ERROR_CONVERT_TO_JSON);
    }
  }

  private LaftCustomerModel getNames(VerificationLaftResponse response) {
    LaftCustomerModel laftCustomer = LaftCustomerModel.builder()
        .companyName(response.getCompanyName())
        .build();

    if ((nonNull(response.getNatureLegalLabel()) && !response.getNatureLegalLabel().isEmpty())
        && !response.getNatureLegalLabel().equals("label_persona_juridica")) {
      if (nonNull(response.getCompanyName()) && !response.getCompanyName().isEmpty()) {
        List<String> splitName = Arrays.stream(response.getCompanyName().split(" ")).toList();
        laftCustomer.setFirstName(splitName.get(0));
        laftCustomer.setLastFirstName(splitName.size() > 1 ? splitName.get(1) : null);
        laftCustomer.setCompanyName(null);
      } else {
        //TODO: Implementar logica para cuando se confirme las consultas por solo nombre del empresa o persona natural
      }
    }
    return laftCustomer;
  }
}

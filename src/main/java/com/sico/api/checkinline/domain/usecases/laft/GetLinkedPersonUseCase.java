package com.sico.api.checkinline.domain.usecases.laft;

import com.sico.api.checkinline.domain.models.general.CompanyBasicInformationOC;
import com.sico.api.checkinline.domain.models.general.report.GeneralInformation;
import com.sico.api.checkinline.domain.models.laft.LinkedPerson;
import com.sico.api.checkinline.infraestructure.gateways.CompanyBasicInformationOCGateway;
import com.sico.api.checkinline.infraestructure.gateways.GeneralInformationGateway;
import com.sico.api.checkinline.infraestructure.gateways.laft.LinkedPersonGateway;
import com.sico.api.checkinline.infraestructure.gateways.laft.LinkedPersonOCGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
public class GetLinkedPersonUseCase {

    private final LinkedPersonGateway linkedPersonGateway;
    private final LinkedPersonOCGateway linkedPersonOCGateway;
    private final GeneralInformationGateway generalInformationGateway;
    private final CompanyBasicInformationOCGateway companyBasicInformationOCGateway;

    public Page<LinkedPerson> getLinkedPersonData(String companyId, boolean isBogota, int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
        GeneralInformation generalInformation = generalInformationGateway.checkOutGeneralInformation(companyId, isBogota);
        if(isBogota){
            return linkedPersonGateway.getLinkedPersonData(generalInformation.getRegister(), pageable);
        }else {
            CompanyBasicInformationOC companyBasicInformationOC = companyBasicInformationOCGateway.getInformationByIdentificationAndRegister(generalInformation.getIdentification(), generalInformation.getRegister());
            return linkedPersonOCGateway.getLinkedPersonData(generalInformation.getRegister(), companyBasicInformationOC.getChamberId(), pageable);
        }
    }
}

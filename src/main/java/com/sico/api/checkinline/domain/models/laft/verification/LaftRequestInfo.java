package com.sico.api.checkinline.domain.models.laft.verification;

import com.sico.api.checkinline.domain.models.identificationtype.IdentificationTypeShort;

public record LaftRequestInfo (IdentificationTypeShort identificationType,
                               String identificationTypeLabel, String natureLegalLabel,
                               String identificationNumber,
                               String companyName){

}

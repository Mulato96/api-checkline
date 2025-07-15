package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.AssociatedEstablishment;

import java.util.List;

public interface AssociatedEstablishmentGateway {

    List<AssociatedEstablishment> checkOutAssociatedEstablishments(String companyId, Boolean isBogota);
}

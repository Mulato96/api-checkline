package com.sico.api.checkinline.domain.port.driver;

import com.sico.api.checkinline.domain.models.general.CompanySearchFilter;
import com.sico.api.checkinline.domain.models.general.search.Company;

import java.util.List;

public interface CompanySearchGateway {

    List<Company> checkOutCompaniesBogotaSearch(CompanySearchFilter companySearchFilter);

    List<Company> checkOutCompaniesNationalSearch(CompanySearchFilter companySearchFilter);

}

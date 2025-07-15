package com.sico.api.checkinline.infraestructure.persistences;


import com.sico.api.checkinline.domain.models.general.CompanySearchFilter;
import com.sico.api.checkinline.domain.port.driver.CompanySearchGateway;
import com.sico.api.checkinline.domain.models.general.search.Company;
import com.sico.api.checkinline.infraestructure.mappers.CompanySearchMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanySearchGatewayImpl implements CompanySearchGateway {

    private final JpaCompanySearchRepository repository;
    private final CompanySearchMapper mapper;

    @Override
    public List<Company> checkOutCompaniesBogotaSearch(CompanySearchFilter companySearchFilter) {    

        return mapper.toDto(repository.checkOutCompaniesBogotaSearch(
            companySearchFilter.getRegistrationFilter(),
            companySearchFilter.getGeneralInformationForm(),                
            companySearchFilter.getIdentificationFilter(),
            companySearchFilter.getCorporateNameInitialsFilter()));
    }

    @Override
    public List<Company> checkOutCompaniesNationalSearch(CompanySearchFilter companySearchFilter) {
        return mapper.toDto(repository.checkOutCompaniesNationalSearch(
                companySearchFilter.getRegistrationFilter(),
                companySearchFilter.getGeneralInformationForm(),
                companySearchFilter.getIdentificationFilter(),
                companySearchFilter.getCorporateNameInitialsFilter()));
    }
}

package com.sico.api.checkinline.domain.usecases;

import com.sico.api.checkinline.domain.models.general.CompanySearch;
import com.sico.api.checkinline.domain.models.general.CompanySearchFilter;
import com.sico.api.checkinline.domain.models.general.search.Company;
import com.sico.api.checkinline.domain.port.driver.CompanySearchGateway;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CheckOutCompanySearchUseCase {
    private Logger logger = Logger.getLogger(CheckOutCompanySearchUseCase.class.getName());
    private final CompanySearchGateway companySearchGateway;

    public CompanySearch checkOutCompanies(CompanySearchFilter companySearchFilter) {
        if (companySearchFilter.getCorporateNameInitialsFilter() == 0
                && companySearchFilter.getIdentificationFilter() == 1
                && companySearchFilter.getRegistrationFilter() == 0) {

            companySearchFilter.setGeneralInformationForm(
                    StringUtils.leftPad(companySearchFilter.getGeneralInformationForm(), 15, '0'));
        }

        long startTime_b = System.currentTimeMillis();
        logger.info("INICIANDO BUSQUEDA DE EMPRESAS EN BOGOTA");
        List<Company> companiesBogotaList = companySearchGateway.checkOutCompaniesBogotaSearch(companySearchFilter);
        logger.info("FINALIZANDO BUSQUEDA DE EMPRESAS EN BOGOTA");
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime_b) / 1000;
        logger.info("DURACION DE BUSQUEDA DE EMPRESAS EN BOGOTA: " + duration + " seconds");

        long startTime_n = System.currentTimeMillis();
        logger.info("INICIANDO BUSQUEDA DE EMPRESAS NACIONALES");
        List<Company> companiesNationalList = companySearchGateway.checkOutCompaniesNationalSearch(companySearchFilter);
        logger.info("FINALIZANDO BUSQUEDA DE EMPRESAS NACIONALES");
        long endTime_n = System.currentTimeMillis();
        long duration_n = (endTime_n - startTime_n) / 1000;
        logger.info("DURACION DE BUSQUEDA DE EMPRESAS NACIONALES: " + duration_n + " seconds");

        return CompanySearch.builder().companies(mergeListSearch(companiesBogotaList, companiesNationalList)).build();                
    }


    private List<Company> mergeListSearch(List<Company> companiesBogotaList, List<Company> companiesNationalList) {
        List<Company> mergeList = new ArrayList<>();

        mergeList.addAll(companiesBogotaList);
        mergeList.addAll(companiesNationalList);

        return mergeList.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

    }

    /*private Integer mergeTotalRecordsFoundSearch(List<Company> companiesBogotaList,
            List<Company> companiesNationalList) {
        Integer totalRecordsFoundBogota = 0;
        Integer totalRecordsFoundNacional = 0;

        if (!companiesBogotaList.isEmpty()) {
            totalRecordsFoundBogota = companiesBogotaList.get(0).getTotalRecordsFound();
        }

        if (!companiesNationalList.isEmpty()) {
            totalRecordsFoundNacional = companiesNationalList.get(0).getTotalRecordsFound();
        }

        return (totalRecordsFoundBogota + totalRecordsFoundNacional);
    }*/
}

package com.sico.api.checkinline.infraestructure.entrypoints;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.usecases.CheckOutCompanySearchUseCase;
import com.sico.api.checkinline.domain.models.general.CompanySearchFilter;
import com.sico.api.checkinline.infraestructure.utils.Logging;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("companies-search")
@RequiredArgsConstructor
@Slf4j
public class CheckOutCompanySearchRestController {

    private final CheckOutCompanySearchUseCase useCase;
    private final MessageTranslator message;

    @Logging
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Success> getCompanySearch(@Valid @RequestBody CompanySearchFilter companySearchFilter) {

        return ResponseEntity.ok().body(new Success(message.getMessage("search.found",
                new Object[] { companySearchFilter.getGeneralInformationForm(),
                        companySearchFilter.getCorporateNameInitialsFilter(),
                        companySearchFilter.getIdentificationFilter(), companySearchFilter.getRegistrationFilter() }),
                useCase.checkOutCompanies(companySearchFilter)));

    }
}

package com.sico.api.checkinline.infraestructure.entrypoints.laft;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Success;
import com.sico.api.checkinline.domain.models.laft.LinkedPerson;
import com.sico.api.checkinline.domain.usecases.laft.GetLinkedPersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("linked-persons")
@RequiredArgsConstructor
public class LinkedPersonController {

    private final GetLinkedPersonUseCase getLinkedPersonUseCase;
    private final MessageTranslator message;

    @GetMapping("/{companyId}/{isBogota}")
    public ResponseEntity<Success> getLinkedPersonData(
            @PathVariable("companyId") String companyId,
            @PathVariable("isBogota") boolean isBogota,
            @RequestParam("page") int page,
            @RequestParam("size") int size) {

        Page<LinkedPerson> linkedPersons = getLinkedPersonUseCase.getLinkedPersonData(companyId, isBogota, page, size);

        if (linkedPersons == null || linkedPersons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(new Success(message.getMessage("data.found", new Object[]{companyId}), linkedPersons));
    }
}
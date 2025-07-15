package com.sico.api.checkinline.domain.models.fiscalauditor;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiscalAuditor {

    private String identification;
    private String name;
    private String description;

}

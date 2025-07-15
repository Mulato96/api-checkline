package com.sico.api.checkinline.domain.models.legalrepresentation;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Certificas implements Serializable {
    private String certificaName;

    private String certificaText;
}

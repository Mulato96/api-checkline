package com.sico.api.checkinline.domain.models.general.report;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Mapeo representantes legales
 */
@Getter
@Setter
public class LegalRepresentative implements Serializable {

    private String documentType;

    private String identification;

    private String name;

    private String position;
}

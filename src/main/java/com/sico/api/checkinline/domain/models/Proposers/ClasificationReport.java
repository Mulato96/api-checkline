package com.sico.api.checkinline.domain.models.Proposers;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClasificationReport implements Serializable {


    private String description;

    private String segment;

    private String family;

    private String clasificationClass;

    private String product;
}

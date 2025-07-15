package com.sico.api.checkinline.domain.models.Proposers;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class OrganizationalCapacityReport implements Serializable {
    private double rentabilidadPatrimonio;

    private double retabilidadActivo;
}

package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FiscalAuditorEntity {

    @Id
    @Column(name = "Identificacion")
    private String identification;
    @Column(name = "nombre_cliente")
    private String name;
    @Column(name = "Vinculo")
    private String description;

}

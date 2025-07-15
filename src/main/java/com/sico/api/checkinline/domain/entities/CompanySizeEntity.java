package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class CompanySizeEntity implements Serializable {

    @Column(name = "IdEmpresa")
    private String companyId;

    @Id
    @Column(name = "NombreTamanio")
    private String name;

    @Column(name = "Tamanio")
    private Integer size;

}

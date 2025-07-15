package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class ExecutiveEntity implements Serializable {

    @Column(name = "IdEmpresa")
    private String companyId;

    @Id
    @Column(name = "Nombre")
    private String name;

    @Column(name = "Cargo")
    private String position;

    @Column(name = "Telefono")
    private String phone;

    @Column(name = "Correo")
    private String email;

}

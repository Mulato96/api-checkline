package com.sico.api.checkinline.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ReferenceEntity implements Serializable {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "NombreReferencia")
    private String name;

    @Column(name = "DireccionReferencia")
    private String address;

    @Column(name = "TelefonoReferencia")
    private String phone;
}

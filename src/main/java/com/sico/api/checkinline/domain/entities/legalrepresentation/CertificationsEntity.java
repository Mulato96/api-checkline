package com.sico.api.checkinline.domain.entities.legalrepresentation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "lu_cliente")
public class CertificationsEntity {

    @Id
    @Column(name="id_cliente")
    private int id;

    @Column(name ="id_proponente")
    private String rup;
}

package com.sico.api.checkinline.domain.entities.legalrepresentation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CertificasEntity {
    @Id
    @Column(name = "ID_CERTIFICA")
    private int idCertifica;

    @Column(name = "NOM_CERTIFICA")
    private String certificaName;

    @Column(name = "TXTCERTIFICA")
    private String certificaText;
}

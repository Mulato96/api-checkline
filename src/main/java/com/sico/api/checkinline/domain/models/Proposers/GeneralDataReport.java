package com.sico.api.checkinline.domain.models.Proposers;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class GeneralDataReport implements Serializable {

    private String proposersNumber;

    private Date inscriptionDate;

    private Date lastRenotationDate;

    private String size;
}

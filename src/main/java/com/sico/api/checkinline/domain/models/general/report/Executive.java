package com.sico.api.checkinline.domain.models.general.report;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Executive implements Serializable {

    private String name;

    private String position;

    private String phone;

    private String email;
}

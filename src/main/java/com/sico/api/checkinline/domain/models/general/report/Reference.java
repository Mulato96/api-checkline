package com.sico.api.checkinline.domain.models.general.report;

import java.io.Serializable;
import lombok.Data;

@Data
public class Reference implements Serializable {

  private String name;
  private String address;
  private String phone;
}

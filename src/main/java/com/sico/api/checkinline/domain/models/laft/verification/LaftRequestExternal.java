package com.sico.api.checkinline.domain.models.laft.verification;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaftRequestExternal implements Serializable {
  private List<LaftRequestEvent> laftRequestPayloads;
  private Long idMailBox;
}

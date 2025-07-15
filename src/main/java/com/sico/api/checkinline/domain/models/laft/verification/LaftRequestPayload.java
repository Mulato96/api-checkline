package com.sico.api.checkinline.domain.models.laft.verification;

import java.util.List;

public record LaftRequestPayload(List<LaftRequestInfo> laftRequestInfoList, Long IdMailBox) {

}

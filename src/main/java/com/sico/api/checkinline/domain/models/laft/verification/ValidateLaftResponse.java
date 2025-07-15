package com.sico.api.checkinline.domain.models.laft.verification;

import java.util.List;
import lombok.Builder;

@Builder
public record ValidateLaftResponse(List<VerificationLaftResponse> requestSuccess,
                                   List<VerificationLaftResponse> requestError) {

}

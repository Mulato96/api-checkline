package com.sico.api.checkinline.domain.models;

import lombok.Builder;

@Builder
public record VerificationLaftParameters(Integer limitMaxPerRequest, Integer processedTimeRequest,
                                         Integer creditValueByRequest, Long sizeMaxPermitted) {

}

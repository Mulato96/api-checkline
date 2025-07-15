package com.sico.api.checkinline.domain.port.driver.laftverification;

import com.sico.api.checkinline.domain.models.laft.verification.LaftRequestExternal;

public interface LaftVerificationGateway {

  void createRequest(LaftRequestExternal laftRequestExternal);
}

package org.bfsi.bureau.service;

import org.bfsi.bureau.bean.BureauResponse;
import org.bfsi.bureau.entity.BureauRequest;

public interface BureauService {

    public BureauRequest saveEntity(BureauRequest bureauRequest);

    BureauResponse checkEligibility(int score, BureauRequest bureauRequest);
}

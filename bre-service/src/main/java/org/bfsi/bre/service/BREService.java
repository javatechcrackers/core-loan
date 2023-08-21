package org.bfsi.bre.service;

import org.bfsi.bre.bean.BRERequest;
import org.bfsi.bre.bean.BREResponse;

public interface BREService {
    BRERequest saveEntity(BRERequest breRequest);

    BREResponse checkEligibility(BRERequest breRequest);
}

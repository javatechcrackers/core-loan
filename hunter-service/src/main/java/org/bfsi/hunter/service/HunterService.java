package org.bfsi.hunter.service;

import org.bfsi.hunter.bean.HunterResponse;
import org.bfsi.hunter.entity.HunterRequest;

public interface HunterService {

    public HunterRequest saveEntity(HunterRequest bureauRequest);

    public HunterResponse checkEligibility(HunterRequest bureauRequest);
}

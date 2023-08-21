package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;

public interface LeadService {

    public LeadResponse persistLeadData(LeadRequest leadRequest);
    public LeadRequest getLeadData(String leadId);

}

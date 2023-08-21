package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LeadRequest;

public interface ConnectorAction {

    public void execute(LeadRequest leadRequest);

}

package org.bfsi.bre.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.bre.bean.BRERequest;
import org.bfsi.bre.bean.BREResponse;
import org.bfsi.bre.controller.BreController;
import org.bfsi.bre.repository.BRERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BREServiceImpl implements BREService{
    Logger logger = LogManager.getLogger(BREServiceImpl.class);
    @Autowired
    BRERepository breRepository;
    @Override
    public BRERequest saveEntity(BRERequest breRequest) {
        logger.info("BREServiceImpl: saveEntity()");
        return breRepository.save(breRequest);
    }

    @Override
    public BREResponse checkEligibility(BRERequest breRequest) {
        logger.info("BREServiceImpl: checkEligibility()");
        return BREResponse.builder().status("Approved")
                .leadId(breRequest.getLeadId())
                .msg("your loan is processed")
                .build();
    }
}

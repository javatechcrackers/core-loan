package org.bfsi.hunter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.hunter.bean.HunterResponse;
import org.bfsi.hunter.entity.HunterRequest;
import org.bfsi.hunter.repository.HunterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HunterServiceImpl implements HunterService {

    Logger logger = LogManager.getLogger(HunterServiceImpl.class);
    @Autowired
    HunterRepository hunterRepository;
    @Override
    public HunterRequest saveEntity(HunterRequest bureauRequest) {
        logger.info("HunterServiceImpl: saveEntity()");
        return hunterRepository.save(bureauRequest);
    }

    @Override
    public HunterResponse checkEligibility( HunterRequest bureauRequest) {
        logger.info("HunterServiceImpl: checkEligibility()");
        if(Integer.valueOf(bureauRequest.getAmount())>500000){
           //throw new ExceededAmountException("your amount is out of allowed range");
        }

       /* String eligibility = "";
        if(score>600){
            eligibility = "green";
        } else if (score<600 && score>450) {
            eligibility = "amber";
        }else {
            eligibility = "red";
        }*/
        HunterResponse bureauResponse = new HunterResponse();
       // bureauResponse.setScore(String.valueOf(score));
        bureauResponse.setLeadId(bureauRequest.getLeadId());
        bureauResponse.setFraud(false);
        bureauResponse.setStatus("No match found");
        bureauResponse.setMsg("Success");

        return bureauResponse;
    }
}

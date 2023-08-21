package org.bfsi.orchestration.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.bfsi.orchestration.entity.LoanRequest;
import org.bfsi.orchestration.repository.BureauRepository;
import org.bfsi.orchestration.service.feign.BureauServiceFeignClient;
import org.bfsi.orchestration.service.feign.entity.BureauRequest;
import org.bfsi.orchestration.service.feign.entity.BureauResponse;
import org.bfsi.orchestration.service.feign.entity.HunterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BureauConnectorService {

    Logger logger = LoggerFactory.getLogger(BureauConnectorService.class);

    @Autowired
    BureauServiceFeignClient bureauServiceFeignClient;

    @Autowired
    BureauRepository bureauRepository;


    @CircuitBreaker(name = "userService", fallbackMethod = "saveFallback")
    public BureauResponse callBureauServiceFeign(BureauRequest bureauRequest) {
        logger.info("Calling Bureau using feign:" + bureauRequest);
        BureauResponse bureauResponse = bureauServiceFeignClient.fetchBureauScore(bureauRequest).getBody();
        logger.info("bureauResponse - " + bureauResponse);
        if(null != bureauResponse){
            bureauRepository.save(bureauResponse);
        }
        return  bureauResponse;
    }

    public BureauResponse saveFallback(Exception e) {
        logger.info("BureauFallback:" + e.toString());
        return new BureauResponse();
    }
}

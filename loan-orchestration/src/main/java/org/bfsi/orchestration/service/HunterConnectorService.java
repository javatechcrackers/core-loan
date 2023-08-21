package org.bfsi.orchestration.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.bfsi.orchestration.entity.LoanRequest;
import org.bfsi.orchestration.repository.HunterRepository;
import org.bfsi.orchestration.service.feign.HunterServiceFeignClient;
import org.bfsi.orchestration.service.feign.entity.BREResponse;
import org.bfsi.orchestration.service.feign.entity.HunterRequest;
import org.bfsi.orchestration.service.feign.entity.HunterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HunterConnectorService {

    Logger logger = LoggerFactory.getLogger(HunterConnectorService.class);

    @Autowired
    HunterServiceFeignClient hunterServiceFeignClient;

    @Autowired
    HunterRepository hunterRepository;


    @CircuitBreaker(name = "userService", fallbackMethod = "saveFallback")
    public HunterResponse callHunterServiceFeign(HunterRequest hunterRequest) {
        logger.info("Calling hunter using feign:" + hunterRequest);
        HunterResponse hunterResponse =  hunterServiceFeignClient.getFraudCheck(hunterRequest).getBody();
        logger.info("hunterResponse - " + hunterResponse);
        if(null != hunterResponse)   hunterRepository.save(hunterResponse);
        return hunterResponse;
    }

    public HunterResponse saveFallback(Exception e) {
        logger.info("HunterFallback:" + e.toString());
        return new HunterResponse();
    }

}



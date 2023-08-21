package org.bfsi.orchestration.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.bfsi.orchestration.entity.LoanRequest;
import org.bfsi.orchestration.repository.BRERepository;
import org.bfsi.orchestration.service.feign.BREServiceFeignClient;
import org.bfsi.orchestration.service.feign.BureauServiceFeignClient;
import org.bfsi.orchestration.service.feign.entity.BRERequest;
import org.bfsi.orchestration.service.feign.entity.BREResponse;
import org.bfsi.orchestration.service.feign.entity.BureauResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BREConnectorService {

    Logger logger = LoggerFactory.getLogger(BREConnectorService.class);

    @Autowired
    BREServiceFeignClient breServiceFeignClient;

    @Autowired
    BRERepository breRepository;

    @CircuitBreaker(name = "userService", fallbackMethod = "saveFallback")
    public BREResponse callBREServiceFeign(BRERequest breRequest) {
        logger.info("Calling BRE using feign:" + breRequest);
        BREResponse breResponse =  breServiceFeignClient.fetchBREScore(breRequest).getBody();
        logger.info("breResponse - " + breResponse);
        if(null != breResponse)   breRepository.save(breResponse);
        return breResponse;
    }

    public BREResponse saveFallback(Exception e) {
        logger.info("BREFallback:" + e.toString());
        return new BREResponse();
    }

}

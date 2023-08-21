package org.bfsi.bre.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.bre.bean.BRERequest;
import org.bfsi.bre.bean.BREResponse;
import org.bfsi.bre.exception.InvalidRequestException;
import org.bfsi.bre.service.BREService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bre")
public class BreController {

    Logger logger = LogManager.getLogger(BreController.class);

    @Autowired
    BREService breService;

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Welcome to BRE", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BREResponse> fetchBureauScore(@RequestBody BRERequest breRequest){
        logger.info("BreController: fetchBureauScore()");
        if(Integer.valueOf(breRequest.getAmount()) < 100){
            throw new InvalidRequestException("Invalid amount");
        }

        logger.info("lead id - " + breRequest.getLeadId());
        breService.saveEntity(breRequest);
        BREResponse response = breService.checkEligibility(breRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

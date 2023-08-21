package org.bfsi.hunter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.hunter.bean.HunterResponse;
import org.bfsi.hunter.entity.HunterRequest;
import org.bfsi.hunter.entity.LeadResponse;
import org.bfsi.hunter.service.HunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hunter")
public class HunterController {
    Logger logger = LogManager.getLogger(HunterController.class);
    @Autowired
    HunterService hunterService;
    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Welcome to Hunter", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HunterResponse> getFraudCheck(@RequestBody HunterRequest hunterRequest){
        logger.info("HunterController: getFraudCheck() " + hunterRequest);
        hunterService.saveEntity(hunterRequest);
        HunterResponse response = hunterService.checkEligibility(hunterRequest);
        logger.info("Response - " + response);
        return new ResponseEntity<HunterResponse>(response, HttpStatus.OK);
    }

}

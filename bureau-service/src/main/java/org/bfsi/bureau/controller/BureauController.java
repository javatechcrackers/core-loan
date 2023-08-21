package org.bfsi.bureau.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.bureau.bean.BureauResponse;
import org.bfsi.bureau.entity.BureauRequest;
import org.bfsi.bureau.entity.LeadResponse;
import org.bfsi.bureau.service.BureauService;
import org.bfsi.bureau.utils.BureauScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bureau")
public class BureauController {

    Logger logger = LogManager.getLogger(BureauController.class);

    @Autowired
    BureauService bureauService;


    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Welcome to Bureau", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BureauResponse> fetchBureauScore(@RequestBody BureauRequest bureauRequest){
        int score = BureauScore.getBureauScore();
        logger.info("Bureau Score is -" + score + " for lead id - " + bureauRequest.getLeadId());
        bureauService.saveEntity(bureauRequest);
        BureauResponse response = bureauService.checkEligibility(score, bureauRequest);
        logger.info("response : " + response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

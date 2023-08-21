package org.bfsi.orchestration.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;
import org.bfsi.orchestration.entity.LoanRequest;
import org.bfsi.orchestration.entity.UserModel;
import org.bfsi.orchestration.exception.InvalidRequestException;
import org.bfsi.orchestration.producer.KafkaProducer;
import org.bfsi.orchestration.service.GenerateLeadService;
import org.bfsi.orchestration.service.LeadService;
import org.bfsi.orchestration.service.RedisDataService;
import org.bfsi.orchestration.service.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/leads")
public class OrchestrationController {

    Logger logger = LogManager.getLogger(OrchestrationController.class);

    @Autowired
    LeadService leadService;

    @Autowired
    GenerateLeadService generateLeadService;

    @Autowired
    UpdateUserService updateUserService;

    @Autowired
    private RedisDataService redisDataService;

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Welcome to Orchestration", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LeadResponse> createLead(@RequestBody LeadRequest leadRequest) {
        logger.info("lead create request received for -" + leadRequest.getContactDetails().getMobileNumber());
        if(leadRequest.getBankDetails().getBankName().isBlank()){
            throw new InvalidRequestException("Bank Name is Mandatory!");
        }

        try {

            String leadId = String.valueOf(UUID.randomUUID());
            leadRequest.setLeadId(leadId);

            leadRequest.getBankDetails().setLeadId(leadId);
            leadRequest.getOfficeAddress().setLeadId(leadId);
            leadRequest.getContactDetails().setLeadId(leadId);
            leadRequest.getPersonalDetails().setLeadId(leadId);
            leadRequest.getHomeAddress().setLeadId(leadId);


            LoanRequest loanRequest = LoanRequest.builder().leadId(leadId)
                    .pan(leadRequest.getPersonalDetails().getPan())
                    .firstName(leadRequest.getPersonalDetails().getFirstName())
                    .lastName(leadRequest.getPersonalDetails().getLastName())
                    .email(leadRequest.getContactDetails().getEmail())
                    .mobileNumber(leadRequest.getContactDetails().getMobileNumber())
                    .build();
            updateUserService.udpateLoanFeign(loanRequest);
            updateUserService.generateNotification(loanRequest, "Loan application process started.");

            leadService.persistLeadData(leadRequest);
            generateLeadService.executeLeadActions(leadRequest);

            LeadResponse response = LeadResponse.builder().statusCode(HttpStatus.OK.toString())
                    .leadId(leadId)
                    .message("Lead process started for given details, please refer the lead Id for future communication - " + leadId).build();
            logger.info("leadRequest -" + leadRequest.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            LeadResponse response = LeadResponse.builder().statusCode(HttpStatus.OK.toString()).message("Some Error occurred").build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<LeadRequest> getLeadDetails(@PathVariable("id") String id){
        LeadRequest leadRequest =   leadService.getLeadData(id);
        return new ResponseEntity<>(leadRequest, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserModel> getLoanAndUserInfo(@PathVariable("id") Long id){
        UserModel model = updateUserService.callUserModelFeign(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/produce")
    public ResponseEntity<String> message(){
        kafkaProducer.sendMessage("Hello from loan orchestration-" );

        return new ResponseEntity<>("Welcome to Orchestration", HttpStatus.OK);
    }

    @GetMapping("/cached-user")
    public ResponseEntity<List<UserModel>> notifyTransactions() {
        logger.info("In cache Controller:");
        return new ResponseEntity<List<UserModel>>(redisDataService.getCacheList(), HttpStatus.OK);

    }



}

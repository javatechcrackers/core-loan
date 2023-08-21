package org.bfsi.user.controller;

import org.bfsi.user.entity.LoanRequest;
import org.bfsi.user.entity.User;
import org.bfsi.user.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class LoanUserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/loans")
    public ResponseEntity<LoanRequest> saveLoanAndUser(@RequestBody LoanRequest loanRequest) {
        return new ResponseEntity<LoanRequest>(userService.saveLoanData(loanRequest), HttpStatus.OK);
    }

}

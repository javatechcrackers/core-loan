package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LoanRequest;
import org.bfsi.orchestration.entity.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", path = "api/v1/users/")
public interface UserServiceFeignClient {

    @GetMapping(value = "/{id}")
    public UserModel getUserDetails(@PathVariable Long id);

    @PostMapping(value = "/loans")
    public ResponseEntity<LoanRequest> saveLeadData(@RequestBody LoanRequest loanRequest);


}
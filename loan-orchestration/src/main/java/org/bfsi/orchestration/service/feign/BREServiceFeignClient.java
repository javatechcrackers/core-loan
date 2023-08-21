package org.bfsi.orchestration.service.feign;

import org.bfsi.orchestration.service.feign.entity.BRERequest;
import org.bfsi.orchestration.service.feign.entity.BREResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bre-service", path = "api/v1/bre/")
public interface BREServiceFeignClient {

    @PostMapping
    public ResponseEntity<BREResponse> fetchBREScore(@RequestBody BRERequest breRequest);

}

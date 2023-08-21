package org.bfsi.orchestration.service.feign;

import org.bfsi.orchestration.service.feign.entity.HunterRequest;
import org.bfsi.orchestration.service.feign.entity.HunterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hunter-service", path = "api/v1/hunter/")
public interface HunterServiceFeignClient {

    @PostMapping
    public ResponseEntity<HunterResponse> getFraudCheck(@RequestBody HunterRequest hunterRequest);

}

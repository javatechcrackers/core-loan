package org.bfsi.orchestration.service.feign;

import org.bfsi.orchestration.service.feign.entity.BureauRequest;
import org.bfsi.orchestration.service.feign.entity.BureauResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bureau-service", path = "api/v1/bureau/")
public interface BureauServiceFeignClient {

    @PostMapping
    public ResponseEntity<BureauResponse> fetchBureauScore(@RequestBody BureauRequest bureauRequest);

}

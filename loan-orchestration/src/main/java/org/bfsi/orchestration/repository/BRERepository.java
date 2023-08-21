package org.bfsi.orchestration.repository;

import org.bfsi.orchestration.service.feign.entity.BREResponse;
import org.bfsi.orchestration.service.feign.entity.BureauResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRERepository extends JpaRepository<BREResponse, Long> {
}

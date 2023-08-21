package org.bfsi.orchestration.repository;

import org.bfsi.orchestration.entity.Address;
import org.bfsi.orchestration.service.feign.entity.BureauResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BureauRepository extends JpaRepository<BureauResponse, Long> {
}

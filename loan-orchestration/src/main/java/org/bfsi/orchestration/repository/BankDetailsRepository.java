package org.bfsi.orchestration.repository;

import org.bfsi.orchestration.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
    BankDetails findByLeadId(String leadId);
}

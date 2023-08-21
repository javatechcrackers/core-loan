package org.bfsi.orchestration.repository;

import org.bfsi.orchestration.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
    ContactDetails findByLeadId(String leadId);
}

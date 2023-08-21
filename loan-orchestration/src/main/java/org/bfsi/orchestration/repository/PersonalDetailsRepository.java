package org.bfsi.orchestration.repository;

import org.bfsi.orchestration.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    PersonalDetails findByLeadId(String leadId);
}

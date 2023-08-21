package org.bfsi.orchestration.repository;

import org.bfsi.orchestration.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByLeadId(String leadId);
}

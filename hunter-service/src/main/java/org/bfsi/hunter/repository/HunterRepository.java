package org.bfsi.hunter.repository;

import org.bfsi.hunter.entity.HunterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HunterRepository extends JpaRepository<HunterRequest, Long> {
}

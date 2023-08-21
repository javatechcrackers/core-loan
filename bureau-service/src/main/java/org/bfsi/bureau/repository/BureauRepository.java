package org.bfsi.bureau.repository;

import org.bfsi.bureau.entity.BureauRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BureauRepository extends JpaRepository<BureauRequest, Long> {
}

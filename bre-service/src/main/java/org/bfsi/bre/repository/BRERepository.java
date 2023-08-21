package org.bfsi.bre.repository;


import org.bfsi.bre.bean.BRERequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRERepository extends JpaRepository<BRERequest, Long> {
}

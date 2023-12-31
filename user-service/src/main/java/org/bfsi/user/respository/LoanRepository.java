package org.bfsi.user.respository;

import org.bfsi.user.entity.LoanRequest;
import org.bfsi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanRequest, Long> {

}

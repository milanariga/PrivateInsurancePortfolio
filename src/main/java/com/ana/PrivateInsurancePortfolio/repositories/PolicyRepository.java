package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.model.Policy;
import com.ana.PrivateInsurancePortfolio.model.Property;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    @Query("SELECT p FROM Policy p WHERE p.policyHolder = ?1")
    List<Policy> findByLoggedUserId(SystemUser user);
}

package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.model.Property;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE p.owner = ?1 and p.active = ?2")
    List<Property> findByUserIdAndActiveTrue(SystemUser user, boolean active);
}

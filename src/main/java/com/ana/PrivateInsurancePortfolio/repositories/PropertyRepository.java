package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}

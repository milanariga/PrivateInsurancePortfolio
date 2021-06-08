package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.owner = ?1 and v.active = ?2")
    List<Vehicle> findByUserIdAndActiveTrue(SystemUser user, boolean active);

    @Query("SELECT v FROM Vehicle v WHERE v.regNo = ?1")
    Vehicle findByRegNo(String regNo);

}

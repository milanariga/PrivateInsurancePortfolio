package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SystemUser, Long> {

    SystemUser findByLogin(String login);
}

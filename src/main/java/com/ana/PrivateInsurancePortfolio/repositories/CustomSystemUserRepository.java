package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.exceptions.InsAuthException;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;

import java.util.Optional;

public interface CustomSystemUserRepository {

    void createSystemUser (SystemUser user);

    Optional<SystemUser> findByLoginAndPassword(String login, String password);

    Integer getCountByLogin(String login);
}

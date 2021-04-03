package com.ana.PrivateInsurancePortfolio.services;

import com.ana.PrivateInsurancePortfolio.exceptions.InsAuthException;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;

public interface SystemUserService {

     SystemUser validateSystemUser(String login, String password) throws InsAuthException;

     SystemUser registerSystemUser(String firstName,
                                   String lastName,
                                   String login,
                                   String password,
                                   String email,
                                   String mobile) throws InsAuthException;
}

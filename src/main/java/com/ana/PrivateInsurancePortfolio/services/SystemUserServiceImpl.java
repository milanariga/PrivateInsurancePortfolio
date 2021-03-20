package com.ana.PrivateInsurancePortfolio.services;

import com.ana.PrivateInsurancePortfolio.exceptions.InsAuthException;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public SystemUser validateSystemUser(String login, String password) throws InsAuthException {
        return null;
    }

    @Override
    public SystemUser registerSystemUser(String firstName,
                                         String lastName,
                                         String login,
                                         String password,
                                         String email,
                                         String mobile) throws InsAuthException {
        Pattern emailPattern = Pattern.compile(("^(.+)@(.+)$"));
        if(email != null) email = email.toLowerCase();
        if(!emailPattern.matcher(email).matches())
            throw new InsAuthException("Invalid email format");

        Pattern namePattern = Pattern.compile(("[a-zA-Z]"));
        if(firstName == null || lastName == null || login == null || password == null || email == null)
            throw new InsAuthException("Please fill in all mandatory fields");

        if (!namePattern.matcher(firstName).matches() || !namePattern.matcher(lastName).matches())
            throw new InsAuthException("Invalid first name or last name format");

        Integer count = userRepository.getCountbyLogin(login);
        if (count > 0)
            throw new InsAuthException("Login already used. Please choose another");

        //Long systemUserId = userRepository.createSystemUser(firstName, lastName, login, password, email, mobile);

        SystemUser user = new SystemUser(firstName,lastName,login,password,email,mobile);

        userRepository.save(user);

        return userRepository.findById(user.getUserId()).orElseThrow(() -> new InsAuthException("No such user found"));
    }
}

package com.ana.PrivateInsurancePortfolio.service;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SystemUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public SystemUser findById(Long id){
        return userRepository.getOne(id);
    }




}

package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/register")
    public void registerSystemUser(@RequestBody SystemUser user){
        userRepository.createSystemUser(user);
    }

//    @RequestMapping("/users")
//    public String getUsers(Model model){
//        model.addAttribute("users", userRepository.findAll());
//
//        return "users/list";
//    }
}

package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String registerSystemUser(@RequestBody Map<String, Object> systemUserMap){
        String firstName = (String) systemUserMap.get("firstName");
        String lastName = (String) systemUserMap.get("lastName");
        String login = (String) systemUserMap.get("login");
        String password = (String) systemUserMap.get("password");
        String email = (String) systemUserMap.get("email");

        return firstName + " " + lastName + ", " + login + " " + password + ", " + email;
    }

//    @RequestMapping("/users")
//    public String getUsers(Model model){
//        model.addAttribute("users", userRepository.findAll());
//
//        return "users/list";
//    }
}

package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new SystemUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerSystemUser(@Valid @ModelAttribute("user") SystemUser user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "register";
        }
        SystemUser userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null){
            //model.put("message", "User already exists! Choose different login");
            return "register";
        }


        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
        System.out.println(user.toString());

        return "redirect:/login";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/register")
//    public void registerSystemUser(@RequestBody SystemUser user){
//        userRepository.createSystemUser(user);
//    }

//    @RequestMapping("/users")
//    public String getUsers(Model model){
//        model.addAttribute("users", userRepository.findAll());
//
//        return "users/list";
//    }
}

package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerSystemUser(SystemUser user, Map<String, Object> model){
        SystemUser userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.put("message", "User already exists! Choose different login");
            return "register";
        }

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

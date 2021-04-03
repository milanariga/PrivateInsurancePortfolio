package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/")
    public String home1(Map<String,Object> model){

        return "home1";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("vehicles", vehicleRepository.findAll());

        return "vehicles/list";
    }
}

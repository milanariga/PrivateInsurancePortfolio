package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.repositories.PropertyRepository;
import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
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
    private VehicleService vehicleService;

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/")
    public String home(Map<String,Object> model){

        return "home";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        model.put("vehicles", vehicleService.findAllByActiveTrue());
        model.put("properties", propertyRepository.findAll());

        return "main";
    }
}

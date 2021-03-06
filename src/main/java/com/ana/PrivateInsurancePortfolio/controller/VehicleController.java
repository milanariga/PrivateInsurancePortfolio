//package com.ana.PrivateInsurancePortfolio.controller;
//
//import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
//import org.dom4j.rule.Mode;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class VehicleController {
//
//    private final VehicleRepository vehicleRepository;
//
//    public VehicleController(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }
//
//    @RequestMapping("/vehicles")
//    public String getVehicles(Model model){
//
//        model.addAttribute("vehicles", vehicleRepository.findAll());
//
//        return "vehicles/list";
//    }
//}

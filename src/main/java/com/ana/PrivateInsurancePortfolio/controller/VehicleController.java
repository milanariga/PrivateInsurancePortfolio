package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping("/vehicles")
    public String getVehicles(Model model){

        model.addAttribute("vehicles", vehicleService.findAllByActiveTrue());

        return "vehicles/vehiclesList";
    }

    @GetMapping("/vehicle-delete/{id}")
    public String deleteVehicle(@PathVariable("id") Long id){
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}

package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable("id") Long id){
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/updateVehicle/{id}")
    public String updateVehicle(@PathVariable("id") Long id, Model model){
        Vehicle veh = vehicleService.findById(id);
        model.addAttribute("vehicle", veh);
        return "vehicles/vehicleUpdate";
    }

    @PostMapping("/vehicle-update")
    public String updateVehicle(@ModelAttribute Vehicle vehicle, Model model){
        model.addAttribute("vehicle", vehicle);
        return "redirect:/vehicles";
    }
}

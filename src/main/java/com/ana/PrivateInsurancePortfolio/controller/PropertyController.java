package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.Property;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.repositories.PropertyRepository;
import com.ana.PrivateInsurancePortfolio.service.PropertyService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @RequestMapping("/properties")
    public String getProperties(Model model){
        model.addAttribute("properties", propertyService.findAllByActiveTrue());

        return "properties/propertiesList";
    }

    @GetMapping("/deleteProperty/{id}")
    public String deleteProperty(@PathVariable("id") Long id){
        propertyService.deleteProperty(id);
        return "redirect:/properties";
    }

    @GetMapping("/addProperty")
    public String addVehicle(Model model){
        Property property = new Property();
        model.addAttribute("property", property);
        return "properties/addProperty";
    }

    @PostMapping("/saveProperty")
    public String saveProperty(@ModelAttribute("property") Property property){
        propertyService.saveNewProperty(property);
        return "redirect:/properties";
    }


    @PostMapping("/updateProperty")
    public String updateProperty(@ModelAttribute("property") Property property){
        propertyService.saveProperty(property);
        return "redirect:/properties";
    }

    @GetMapping("/updateProperty/{id}")
    public String updateProperty(@PathVariable("id") Long id, Model model){
        Property prop = propertyService.findById(id);
        model.addAttribute("property", prop);
        return "properties/updateProperty";
    }
}

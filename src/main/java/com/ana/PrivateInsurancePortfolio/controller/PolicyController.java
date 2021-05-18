package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.Policy;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.repositories.PolicyRepository;
import com.ana.PrivateInsurancePortfolio.service.PolicyService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @RequestMapping("/policies")
    public String getPolicies(Model model){
        model.addAttribute("policies", policyService.findAllUserPolicy());

        return "policies/list";
    }

    @PostMapping("/updatePolicy")
    public String updatePolicy(@ModelAttribute("policy") Policy policy){
        policyService.savePolicy(policy);
        return "redirect:/policies";
    }

    @GetMapping("/updatePolicy/{id}")
    public String updatePolicy(@PathVariable("id") Long id, Model model){
        Policy pol = policyService.findById(id);
        model.addAttribute("policy", pol);
        return "policies/updatePolicy";
    }
}

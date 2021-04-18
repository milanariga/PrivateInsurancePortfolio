package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.repositories.PolicyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PolicyController {

    private final PolicyRepository policyRepository;

    public PolicyController(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @RequestMapping("/policies")
    public String getPolicies(Model model){
        model.addAttribute("policies", policyRepository.findAll());

        return "policies/list";
    }
}

package com.ana.PrivateInsurancePortfolio.service;

import com.ana.PrivateInsurancePortfolio.model.Policy;
import com.ana.PrivateInsurancePortfolio.model.PolicyStatus;
import com.ana.PrivateInsurancePortfolio.model.Property;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.PolicyRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private UserService userService;

    public PolicyService(PolicyRepository policyRepository, UserService userService) {
        this.policyRepository = policyRepository;
        this.userService = userService;
    }

    public List<Policy> findAllUserPolicy(){
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        SystemUser owner = userService.findByUsername(username);
        return policyRepository.findByLoggedUserId(owner);
    }

    public void deletePolicy(Long id){
        Policy policy = policyRepository.getOne(id);
        policy.setStatus(PolicyStatus.REJECTED);
        policyRepository.save(policy);
    }

    public void savePolicy(Policy policy){
        policyRepository.save(policy);
    }

    public void saveNewPolicy(Policy policy){
        String username = "";
        if (policy.getPolicyHolder() == null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
        }
        SystemUser owner = userService.findByUsername(username);
        policy.setPolicyHolder(owner);
        policyRepository.save(policy);
    }

    public Policy findById(Long id){
        return policyRepository.getOne(id);
    }

}


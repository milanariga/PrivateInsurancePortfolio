package com.ana.PrivateInsurancePortfolio.service;


import com.ana.PrivateInsurancePortfolio.model.Property;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.PropertyRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private UserService userService;

    public PropertyService(PropertyRepository propertyRepository, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.userService = userService;
    }

    public List<Property> findAllByActiveTrue(){
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        SystemUser owner = userService.findByUsername(username);
        return propertyRepository.findByUserIdAndActiveTrue(owner, true);
    }

    public void deleteProperty(Long id){
        Property property = propertyRepository.getOne(id);
        property.setActive(false);
        propertyRepository.save(property);
    }

    public void saveProperty(Property property){
        propertyRepository.save(property);
    }

    public void saveNewProperty(Property property){
        String username = "";
        if (property.getOwner() == null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
        }
        SystemUser owner = userService.findByUsername(username);
        property.setOwner(owner);
        propertyRepository.save(property);
    }

    public Property findById(Long id){
        return propertyRepository.getOne(id);
    }

}

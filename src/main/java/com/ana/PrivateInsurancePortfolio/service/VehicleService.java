package com.ana.PrivateInsurancePortfolio.service;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private UserService userService;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository,
                          UserService userService) {
        this.vehicleRepository = vehicleRepository;
        this.userService = userService;
    }

    public List<Vehicle> findAllByActiveTrue(){
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        SystemUser owner = userService.findByUsername(username);
        return vehicleRepository.findByUserIdAndActiveTrue(owner, true);
    }

    public void deleteVehicle(Long id){
        Vehicle veh = vehicleRepository.getOne(id);
        veh.setActive(false);
        vehicleRepository.save(veh);
    }

//    public void saveVehicle(Vehicle vehicle){
//        vehicleRepository.save(vehicle);
//    }

    public boolean saveVehicle(Vehicle vehicle){
        String username = "";
        if (vehicle.getOwner() == null){
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            SystemUser owner = userService.findByUsername(username);
            vehicle.setOwner(owner);
        }

        vehicleRepository.save(vehicle);
        return true;
    }

    public Vehicle findById(Long id){
        return vehicleRepository.getOne(id);
    }

    public Vehicle findByRegNo(String regNo) {
        return vehicleRepository.findByRegNo(regNo);
    }
}

package com.ana.PrivateInsurancePortfolio.service;

import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.repositories.PolicyRepository;
import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final PolicyRepository policyRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, PolicyRepository policyRepository) {
        this.vehicleRepository = vehicleRepository;
        this.policyRepository = policyRepository;
    }

    public List<Vehicle> findAllByActiveTrue(){
        return vehicleRepository.findByActiveTrue(true);
    }

    public void deleteVehicle(Long id){
        Vehicle veh = vehicleRepository.getOne(id);
        veh.setActive(false);
        vehicleRepository.save(veh);
    }

    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public Vehicle findById(Long id){
        return vehicleRepository.getOne(id);
    }
}

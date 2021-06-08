package com.ana.PrivateInsurancePortfolio.service;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.model.VehicleType;
import com.ana.PrivateInsurancePortfolio.repositories.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private Authentication auth;

    @Mock
    VehicleRepository vehicleRepository;

    @Mock
    UserService userService;


//    @Test
//    public void shouldReturnListOfVehicles(){
//        SystemUser user = new SystemUser("John", "Doe", "JonhDoe", "12345", "jd@jd.com", "123123123", true);
//        Vehicle testVehicle1 = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);
//        Vehicle testVehicle2 = new Vehicle(VehicleType.MOTORCYCLE, "Moto", "312", 1999, "T543LA", "A54892", user);
//
//        List<Vehicle> userVehicles = new ArrayList<>();
//        userVehicles.add(testVehicle1);
//        userVehicles.add(testVehicle2);
//
//        Mockito.when(auth.getPrincipal()).thenReturn(new Object());
//
//        Mockito.when(vehicleRepository.findByUserIdAndActiveTrue(user,true)).thenReturn(userVehicles);
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        VehicleService vehService = new VehicleService(vehicleRepository, userService);
//        vehService.findAllByActiveTrue();
//    }


    //TODO save Vehicle

    @Test
    public void shouldSearchVehicleById(){
        Long testId = 1L;
        SystemUser user = new SystemUser();
        Vehicle testVehicle1 = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);

        Mockito.when(vehicleRepository.getOne(testId)).thenReturn(testVehicle1);

        VehicleService vehService = new VehicleService(vehicleRepository, userService);
        vehService.findById(testId);
    }


    @Test
    public void shouldNotFindVehicleById() throws RuntimeException{
        Long testId = 1L;
        SystemUser user = new SystemUser();
        Vehicle testVehicle1 = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);

        Mockito.when(vehicleRepository.getOne(testId)).thenReturn(testVehicle1).thenThrow(new RuntimeException());

        VehicleService vehService = new VehicleService(vehicleRepository, userService);
        vehService.findById(testId);

        Mockito.verify(vehicleRepository, Mockito.times(1)).getOne(testId);
    }

    @Test
    public void shouldCallRepositoryDeleteVehicle() throws SQLException {
        Long testId = 1L;
        SystemUser user = new SystemUser();
        Vehicle testVehicle1 = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);

        Mockito.when(vehicleRepository.getOne(testId)).thenReturn(testVehicle1);
        Mockito.when(vehicleRepository.save(testVehicle1)).thenReturn(testVehicle1);

        VehicleService vehService = new VehicleService(vehicleRepository, userService);
        vehService.deleteVehicle(testId);
    }

}
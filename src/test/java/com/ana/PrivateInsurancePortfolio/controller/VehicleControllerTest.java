package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.model.VehicleType;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

    @Mock
    Model model;

    @Mock
    VehicleService vehicleService;

    public SystemUser createUser(){
        return new SystemUser();
    }

    public Vehicle createVehicle (){
        return new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", createUser());
    }

    public Vehicle createVehicle (VehicleType type, String make){
        return new Vehicle(type, make, "312", 1999, "T543LA", "A54892", createUser());
    }


    @Test
    public void whenValidObjectShouldSaveToDB(){
        Vehicle testVehicle = createVehicle();

        Mockito.when(vehicleService.saveVehicle(testVehicle)).thenReturn(true);

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.saveVehicle(testVehicle);

        Mockito.verify(vehicleService, Mockito.times(1)).saveVehicle(testVehicle);

    }

    @Test
    public void whenErrorOfDBShouldReturnError() throws RuntimeException{

        Vehicle testVehicle = createVehicle();

        Mockito.when(vehicleService.saveVehicle(testVehicle)).thenReturn(true).thenThrow(new RuntimeException());

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.saveVehicle(testVehicle);

    }

    @Test
    public void whenExistsShouldReturnListOfVehicles(){
        SystemUser user = new SystemUser();
        Vehicle testVehicle1 = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);
        Vehicle testVehicle2 = new Vehicle(VehicleType.MOTORCYCLE, "Moto", "312", 1999, "T543LA", "A54892", user);

        List<Vehicle> userVehicles = new ArrayList<>();
        userVehicles.add(testVehicle1);
        userVehicles.add(testVehicle2);

        Mockito.when(vehicleService.findAllByActiveTrue()).thenReturn(userVehicles);

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.getVehicles(model);

    }

    @Test
    public void whenGetVehiclesErrorShouldReturnError() throws RuntimeException{
        SystemUser user = new SystemUser();
        Vehicle testVehicle1 = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);
        Vehicle testVehicle2 = new Vehicle(VehicleType.MOTORCYCLE, "Moto", "312", 1999, "T543LA", "A54892", user);

        List<Vehicle> userVehicles = new ArrayList<>();
        userVehicles.add(testVehicle1);
        userVehicles.add(testVehicle2);

        Mockito.when(vehicleService.findAllByActiveTrue()).thenReturn(userVehicles).thenThrow(new RuntimeException());

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.getVehicles(model);

    }

    @Test
    public void whenDeleteVehicleSuccess() throws Exception {
        Long testId = 1L;

        Mockito.when(vehicleService.deleteVehicle(testId)).thenReturn(testId);

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.deleteVehicle(testId);

        Mockito.verify(vehicleService,Mockito.times(1)).deleteVehicle(testId);
    }

    @Test
    public void whenDeleteNotExistingVehicleShouldThrowError() throws Exception{
        Long testId = 5L;

        Mockito.when(vehicleService.deleteVehicle(testId)).thenReturn(testId).thenThrow(new SQLException());

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.deleteVehicle(testId);
    }


    //TODO Update vehicle


}
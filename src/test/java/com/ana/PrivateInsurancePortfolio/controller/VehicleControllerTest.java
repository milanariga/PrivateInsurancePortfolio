package com.ana.PrivateInsurancePortfolio.controller;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.model.Vehicle;
import com.ana.PrivateInsurancePortfolio.model.VehicleType;
import com.ana.PrivateInsurancePortfolio.service.UserService;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
import org.aspectj.lang.annotation.Before;
import org.checkerframework.checker.fenum.qual.AwtAlphaCompositingRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

    @Mock
    Model model;

    @Mock
    VehicleService vehicleService;

    @Mock
    UserService userService;

    @Autowired
    VehicleController vehicleController;

//    @Before
//    public void setup(){
//        VehicleController vehicleController = new VehicleController();
//    }
    @Test
    public void whenValidObjectShouldSaveToDB(){

        SystemUser user = new SystemUser();
        Vehicle testVehicle = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);

        Mockito.when(vehicleService.saveVehicle(testVehicle)).thenReturn(true);

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.saveVehicle(testVehicle);

        Mockito.verify(vehicleService, Mockito.times(1)).saveVehicle(testVehicle);

    }

    @Test
    public void whenErrorOfDBShouldReturnError() throws RuntimeException{

        SystemUser user = new SystemUser();
        Vehicle testVehicle = new Vehicle(VehicleType.TRACTOR, "Belarus", "312", 1999, "T543LA", "A54892", user);

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
    public void whenDeleteVehicleSuccess(){
        Long testId = 1L;

        Mockito.doNothing().when(vehicleService).deleteVehicle(testId);

        VehicleController vehContr = new VehicleController(vehicleService);
        vehContr.deleteVehicle(testId);

        Mockito.verify(vehicleService,Mockito.times(1)).deleteVehicle(testId);
    }

//    @Test
//    public void whenDeleteNotExistingVehicle() throws RuntimeException{
//        Long testId = 1L;
//
//        Mockito.doThrow(new RuntimeException()).when(vehicleService).deleteVehicle(testId);
//        //Mockito.when(vehicleService.deleteVehicle(testId)).thenThrow()
//
//        VehicleController vehContr = new VehicleController(vehicleService);
//        vehContr.deleteVehicle(testId);
//    }



}
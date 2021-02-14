package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private VehicleType type;
    private String make;
    private String model;
    private int makeYear;
    private String regNo;
    private String certNo;
}

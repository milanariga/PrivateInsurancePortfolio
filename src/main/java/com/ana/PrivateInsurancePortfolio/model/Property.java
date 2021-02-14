package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private int constrYear;
    private Double area;
    private int NumOfFloor;

    public Property() {
    }

    public Property(Long id, String address, int constrYear, Double area, int numOfFloor) {
        this.id = id;
        this.address = address;
        this.constrYear = constrYear;
        this.area = area;
        NumOfFloor = numOfFloor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getConstrYear() {
        return constrYear;
    }

    public void setConstrYear(int constrYear) {
        this.constrYear = constrYear;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public int getNumOfFloor() {
        return NumOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        NumOfFloor = numOfFloor;
    }
}

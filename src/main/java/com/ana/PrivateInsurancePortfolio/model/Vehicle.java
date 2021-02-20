package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    private VehicleType type;
    private String make;
    private String model;
    private int makeYear;
    private String regNo;
    private String certNo;

    @ManyToMany(mappedBy = "insuredObjects")
    private Set<Policy> policies;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId, VehicleType type, String make, String model, int makeYear, String regNo, String certNo, Set<Policy> policies, User user) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.make = make;
        this.model = model;
        this.makeYear = makeYear;
        this.regNo = regNo;
        this.certNo = certNo;
        this.policies = policies;
        this.user = user;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public Set<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(Set<Policy> policies) {
        this.policies = policies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", type=" + type +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", makeYear=" + makeYear +
                ", regNo='" + regNo + '\'' +
                ", certNo='" + certNo + '\'' +
                ", policies=" + policies +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return vehicleId != null ? vehicleId.equals(vehicle.vehicleId) : vehicle.vehicleId == null;
    }

    @Override
    public int hashCode() {
        return vehicleId != null ? vehicleId.hashCode() : 0;
    }
}

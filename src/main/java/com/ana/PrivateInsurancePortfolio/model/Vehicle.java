package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_sequence"
    )
    @Column(
            name = "vehicle_id",
            updatable = false
    )
    private Long vehicleId;

    //@Enumerated
    @Convert(converter = VehicleTypeConverter.class)
    private VehicleType type;

    @Column(
            name = "make",
            nullable = false,
            columnDefinition = "VARCHAR(20)"
    )
    private String make;

    @Column(
            name = "model",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String model;

    @Column(
            name = "make_year",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private int makeYear;

    @Column(
            name = "reg_no",
            nullable = false,
            columnDefinition = "VARCHAR(10)"
    )
    private String regNo;

    @Column(
            name = "cert_no",
            nullable = false,
            columnDefinition = "VARCHAR(20)"
    )
    private String certNo;

//    @ManyToMany(mappedBy = "insuredObjects")
//    private Set<Policy> policies = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public Vehicle() {
    }

    public Vehicle(VehicleType type, String make, String model, int makeYear, String regNo, String certNo, Person owner) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.makeYear = makeYear;
        this.regNo = regNo;
        this.certNo = certNo;
        this.owner = owner;
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

//    public Set<Policy> getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(Set<Policy> policies) {
//        this.policies = policies;
//    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
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
                //", policies=" + policies +
                ", owner=" + owner +
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

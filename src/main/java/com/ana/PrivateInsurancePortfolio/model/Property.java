package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Property {

    @Id
    @SequenceGenerator(
            name = "property_sequence",
            sequenceName = "property_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "property_sequence"
    )
    @Column(
            name = "property_id",
            updatable = false
    )
    private Long propertyId;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "VARCHAR(100)"
    )
    private String address;

    @Column(
            name = "construction_year",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private int constrYear;

    @Column(
            name = "area",
            nullable = false,
            columnDefinition = "NUMERIC(6,2)"
    )
    private Double area;

    @Column(
            name = "floors",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private int numOfFloor;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    //@ManyToMany(mappedBy = "policyId")
    //private Set<Policy> policies;

    public Property() {
    }

    public Property(String address, int constrYear, Double area, int numOfFloor, Person owner//, Set<Policy> policies
                    ) {
        this.address = address;
        this.constrYear = constrYear;
        this.area = area;
        this.numOfFloor = numOfFloor;
        this.owner = owner;
        //this.policies = policies;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
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
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
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
        return "Property{" +
                "propertyId=" + propertyId +
                ", address='" + address + '\'' +
                ", constrYear=" + constrYear +
                ", area=" + area +
                ", NumOfFloor=" + numOfFloor +
                ", owner =" + owner +
                //", policies=" + policies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return propertyId != null ? propertyId.equals(property.propertyId) : property.propertyId == null;
    }

    @Override
    public int hashCode() {
        return propertyId != null ? propertyId.hashCode() : 0;
    }
}

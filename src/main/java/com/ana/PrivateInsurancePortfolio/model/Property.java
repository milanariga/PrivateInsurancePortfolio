package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {

    @Id
    @SequenceGenerator(
            name = "property_sequence",
            sequenceName = "property_sequence",
            allocationSize = 1,
            initialValue = 300
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
            name = "active",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private boolean active = true;

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
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_property_owner_id")
    )
    private SystemUser owner;

    @ManyToMany(mappedBy = "insuredProperties")
    private List<Policy> policies = new ArrayList<>();

    public Property() {
    }

    public Property(String address, int constrYear, Double area, int numOfFloor, SystemUser owner
                    ) {
        this.address = address;
        this.constrYear = constrYear;
        this.area = area;
        this.numOfFloor = numOfFloor;
        this.owner = owner;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policy) {
        this.policies = policy;
    }

    public void addPolicy(Policy policy){
        this.policies.add(policy);
        policy.getInsuredProperties().add(this);
    }

    public void removePolicy(Policy policy){
        this.policies.remove(policy);
        policy.getInsuredProperties().remove(this);
    }

    public SystemUser getOwner() {
        return owner;
    }

    public void setOwner(SystemUser owner) {
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
